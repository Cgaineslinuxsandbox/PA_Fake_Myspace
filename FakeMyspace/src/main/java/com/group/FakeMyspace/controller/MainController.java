package com.group.FakeMyspace.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.group.FakeMyspace.models.Message;
import com.group.FakeMyspace.models.Picture;
import com.group.FakeMyspace.models.User;
import com.group.FakeMyspace.services.PServ;
import com.group.FakeMyspace.services.UServ;



@Controller
public class MainController {
	
	private final UServ uServ;
    
	public MainController(UServ uServ) {
		this.uServ = uServ;
		}
	
	@Autowired
	private PServ pServ;
	
	
	//	@Autowired
//	private  UServ uServ;
	
	
	
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/img/";
	
	
	

	@GetMapping("/")
	public String index(Model viewModel) {
		return "index.jsp";
	}
	
	 @GetMapping("/auth")
	    public String home(@ModelAttribute("user") User user) {
	    	return "logReg.jsp";
	    }
	    
	@PostMapping("/auth")
	public String re(@Valid @ModelAttribute("user") User user, BindingResult rslt, HttpSession session) {
		String password = user.getPassword();
	    String confirmPassword = user.getPasswordConfirm();
	    if(rslt.hasErrors()) {
	    	return "logReg.jsp";
	    }
	    else if(!password.equals(confirmPassword)){
	    	return "logReg.jsp";
	    }
	    else {
	    User usr = uServ.registerUser(user);
	    session.setAttribute("userId", usr.getId());
	    return "redirect:/main/{id}";
	    }
	}
	
	    @PostMapping("/login")
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	    	boolean isAuth = uServ.authenticateUser(email, password);
	    		if(isAuth) {
	    			User usr= uServ.findByEmail(email);
	    			session.setAttribute("userId", usr.getId());
	    			return "redirect:/main/{id}";
	    		}
	    		else {
	    			model.addAttribute("error", "Invalid Creds, Try Again");
	    			return "logReg.jsp";
	    		}
	    	
	    	
	    }
	
	

	    
	    
	    
	    //=============================Post Mapping to the Message. Needs a link to this in the profile.jsp====================================//
	    public Long userSessionId(HttpSession session) {
			if(session.getAttribute("user___Id") == null) {
				return null;
			}
			return (Long)session.getAttribute("user___Id");
		}
	    
	    @PostMapping("/main/{id}/message") 
		public String Create(@Valid @ModelAttribute("message") Message message, BindingResult result, Model viewModel, HttpSession session, @RequestParam("name") String name, @RequestParam("content") String content) {
			if(result.hasErrors()) {
				Long userId = this.userSessionId(session);
				User user = this.uServ.findUserById(userId);
				viewModel.addAttribute("user", user);
				return "profile.jsp";
			}
			Long userId = this.userSessionId(session);
			User user = this.uServ.findUserById(userId);
			message.setSender(user);
			this.Create(message, result, viewModel, session, name, content);
			return "redirect:/main/{id}/message/sent";
		}
	    
	    @GetMapping("/main/{id}/message/sent")
	    public String Sent() {
	    	return "sent.jsp";
	    }
	    
	    @PostMapping("/main/imageUpload")
		public String up(@RequestParam("pic") MultipartFile file, HttpSession session, Model model, @RequestParam("user") Long id) {
			
			User newPic = new User();
			Long userId = (Long)session.getAttribute("userId");
			newPic.setId(id);
			
			
			try {
	    		byte[] bytes = file.getBytes();
	    		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	    		Files.write(path, bytes);
	    		String url = "/img/" + file.getOriginalFilename();
	    		this.pServ.uploadPic(url, newPic);
	    		}
	    	catch(IOException e) {
	    		e.printStackTrace();
	    	}
			
			return "redirect/main/"+userId;
		}
	
}
