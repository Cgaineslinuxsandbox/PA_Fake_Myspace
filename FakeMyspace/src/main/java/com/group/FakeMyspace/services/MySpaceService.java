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
<<<<<<< HEAD
	//public List<Friend> findTopEightOfOwner(User owner){
		//return this.fRepo.findAllByOwnerAndTopEightTrue(owner, true);
	//}
=======
	public List<Friend> findTopEightOfOwner(User owner){
		return this.fRepo.findAllByOwnerAndTopEightTrue(owner);
	}
>>>>>>> dfbec0ee0adca766eef871d84a0d5d60aa489e13
	
	
	
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
