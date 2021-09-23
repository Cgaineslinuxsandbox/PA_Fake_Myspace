package com.group.FakeMyspace.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group.FakeMyspace.models.Comment;
import com.group.FakeMyspace.models.Friend;
import com.group.FakeMyspace.models.User;
import com.group.FakeMyspace.services.MySpaceService;
import com.group.FakeMyspace.services.UServ;

@Controller
public class HomeController {
	
	//@Autowired
	//public MySpaceService mServ;
	@Autowired
	public UServ uServ;

	
	//========== MainPage =========//
	@GetMapping("/main/{id}")
	public String mainPage(HttpSession session, @ModelAttribute("comment")Comment comment, Model viewModel, @ModelAttribute("User") User user, @PathVariable("id") Long uid) {
		Long userId = (Long)session.getAttribute("userId");
		User usr = this.uServ.findUserById(userId);
		viewModel.addAttribute("user", usr);
		
		
		//List<Friend> top8 = this.mServ.findTopEightOfOwner(user);
		//viewModel.addAttribute("top8", top8);
		return  "Profile.jsp";
	}
	
	@PostMapping("/main/{id}/postComment")
	public String postComment(@PathVariable("id")Long uid, HttpSession session, @Valid@ModelAttribute("comment")Comment comment, Model viewModel, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You need to log in first!");
			return "redirect:/auth";
		}
		User user = this.uServ.findUserById(uid);
		viewModel.addAttribute("user", user);
		Long userId = (Long)session.getAttribute("userId");
		//this.mServ.createComm(comment);
		return "redirect/main/"+userId;
		
	}
	
	

	//========== View All Friend Page =========//
	@GetMapping("/{id}/allfriends")
	public String allFriend(HttpSession session, @ModelAttribute("friend")Friend friend, Model viewModel, @PathVariable("id")Long uid) {
		Long userId = (Long)session.getAttribute("userId");
		User user = this.uServ.findUserById(userId);
		viewModel.addAttribute("user", user);
		
		List<Friend> allFrnd = user.getFriend();
		viewModel.addAttribute("allFrnd", allFrnd);
		
		//List<Friend> top8 = this.mServ.findTopEightOfOwner(user);
		//viewModel.addAttribute("top8", top8);
		return "AllFriend.jsp";
	}
	
	//========== Add a Friend to Top8 =========//
	//******** Need to have a validation of top8 friend quantity of a user by measuring the size of this.mServ.findTopEightOfOwner(user) ********//
		
	//========== Remove a Friend from Top8 =========//
	//******** If we are changing the boolean to remove a friend from Top8, should we use @GetMapping or @PostMapping ********//
	
	//========== Delete a friend =========//
//	@GetMapping("/deleteFriend/{id}")
//	public String DeleteTask(@PathVariable("id")Long fid) {
//		this.fServ.delete(fid);
//		return "redirect:/tasks";
//	}

	
	
	
	
	

}
