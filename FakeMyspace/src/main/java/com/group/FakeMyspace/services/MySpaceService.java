package com.group.FakeMyspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.FakeMyspace.models.Comment;
import com.group.FakeMyspace.models.Friend;
import com.group.FakeMyspace.models.User;
import com.group.FakeMyspace.repo.CommentRepository;
import com.group.FakeMyspace.repo.FriendRepository;

@Service
public class MySpaceService {
	
	@Autowired
	public FriendRepository fRepo;
	@Autowired
	public CommentRepository cRepo;
	
	
	
	//========== User ========//
	//Top8 List
	public List<Friend> findTopEightOfOwner(User owner){
		return this.fRepo.findAllByOwnerAndTopEightTrue(owner, Class<Boolean>);
	}
	
	
	
	//========== Comment ========//
	//Create
	public Comment createComm(Comment newComment) {
		return this.cRepo.save(newComment);
	}
	
	//Show All
	public List<Comment> showAllComments(User receiver){
		return this.cRepo.findAllByReceiver(receiver);
	}

}
