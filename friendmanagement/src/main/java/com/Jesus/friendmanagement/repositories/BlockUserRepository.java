package com.Jesus.friendmanagement.repositories;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.Jesus.friendmanagement.models.BlockUser;

@Repository
public interface BlockUserRepository {
	Map<String, Object> addBlockUser(BlockUser blockUser);
}
