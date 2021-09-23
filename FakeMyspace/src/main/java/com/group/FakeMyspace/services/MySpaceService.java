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
//<<<<<<< Updated upstream
//=======
//
//	//public List<Friend> findTopEightOfOwner(User owner){
//		//return this.fRepo.findAllByOwnerAndTopEightTrue(owner, true);
//	//}
//
//>>>>>>> Stashed changes
//	public List<Friend> findTopEightOfOwner(User owner){
//		return this.fRepo.findAllByOwnerAndTopEightTrue(owner, true);
//	}
//<<<<<<< Updated upstream
//=======
//
//>>>>>>> Stashed changes
//	
	
	
	//========== Comment ========//
	//Create
	public Comment createComm(Comment newComment) {
		return this.cRepo.save(newComment);
	}

}
