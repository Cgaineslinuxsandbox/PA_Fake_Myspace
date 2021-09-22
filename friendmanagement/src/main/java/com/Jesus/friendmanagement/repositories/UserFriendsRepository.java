package com.Jesus.friendmanagement.repositories;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.Jesus.friendmanagement.models.UserFriends;

@Repository
public interface UserFriendsRepository {
	Map<String, Object> addUserFriends(UserFriends userFriendsRequest);

	Map<String, Object> getUserFriendsList(UserFriends userFriendsListRequest);

	Map<String, Object> getCommonUserFriends(UserFriends userFriendsRequest);
}
