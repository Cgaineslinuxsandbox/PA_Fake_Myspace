package com.group.FakeMyspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.FakeMyspace.models.Friend;
import com.group.FakeMyspace.repo.FriendRepository;

@Service
public class FriendService {
	@Autowired
	private FriendRepository fRepo;
	
//	public List<Friend> getAllFriends(){
//		return this.fRepo.findAll();
//	}
//	
//	public List<Friend> findTopEight(boolean topEight){
//		return this.fRepo.findAllByTopEightTrue(topEight);
//	}
	
	public Friend findbyId(Long id) {
		return this.fRepo.findById(id).orElse(null);
	}
	
	public Friend create(Friend friend) {
		return this.fRepo.save(friend);
	}
	
	public Friend update(Friend friend) {
		return this.fRepo.save(friend);
	}
	
	public void delete(Long id) {
		this.fRepo.deleteById(id);
	}
}
