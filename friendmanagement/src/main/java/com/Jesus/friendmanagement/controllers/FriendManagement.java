package com.Jesus.friendmanagement.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Jesus.friendmanagement.models.BlockUser;
import com.Jesus.friendmanagement.models.SubscribeUser;
import com.Jesus.friendmanagement.models.UserFriends;
import com.Jesus.friendmanagement.repositories.BlockUserRepository;
import com.Jesus.friendmanagement.repositories.SubscribeUserRepository;
import com.Jesus.friendmanagement.repositories.UserFriendsRepository;

@Controller
public class FriendManagement {
	@Autowired
	private UserFriendsRepository uFRepo;

	@Autowired
	private SubscribeUserRepository sURepo;

	@Autowired
	private BlockUserRepository bURepo;

	@PostMapping("/userFriendRequest")
	public Map<String, Object> userFriendRequest(@RequestBody UserFriends userFriends) {
		return this.uFRepo.addUserFriends(userFriends);
	}

	@PostMapping("/getUserFriendList")
	public Map<String, Object> getUserFriendList(@RequestBody UserFriends userFriendsList) {
		return this.uFRepo.getUserFriendsList(userFriendsList);
	}

	@PostMapping("/getCommonUserFriends")
	public Map<String, Object> getCommonUserFriends(@RequestBody UserFriends userFriends) {
		return this.uFRepo.getCommonUserFriends(userFriends);
	}

	@PostMapping("/subscribeUserRequest")
	public Map<String, Object> subscribeUserRequest(@RequestBody SubscribeUser subscribeUser) {
		return this.sURepo.addSubscribeUser(subscribeUser);
	}

	@PostMapping("/blockUserRequest")
	public Map<String, Object> blockUserRequest(@RequestBody BlockUser blockUser) {
		return this.bURepo.addBlockUser(blockUser);
	}
}
