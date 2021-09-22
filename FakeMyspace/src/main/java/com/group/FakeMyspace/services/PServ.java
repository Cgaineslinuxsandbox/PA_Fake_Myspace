package com.group.FakeMyspace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.FakeMyspace.models.Picture;
import com.group.FakeMyspace.models.User;
import com.group.FakeMyspace.repo.PictureRepository;



@Service
public class PServ {

	
	
	@Autowired
	private PictureRepository pRepo;
	
	
	public void uploadPic(String image_url, User user) {
		Picture newPic = new Picture(image_url, user);
		this.pRepo.save(newPic);
	}
}
