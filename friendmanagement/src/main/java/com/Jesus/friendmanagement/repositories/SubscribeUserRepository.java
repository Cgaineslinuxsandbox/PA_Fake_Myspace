package com.Jesus.friendmanagement.repositories;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.Jesus.friendmanagement.models.SubscribeUser;

@Repository
public interface SubscribeUserRepository {
	Map<String, Object> addSubscribeUser(SubscribeUser subscribeUserRequest);
}
