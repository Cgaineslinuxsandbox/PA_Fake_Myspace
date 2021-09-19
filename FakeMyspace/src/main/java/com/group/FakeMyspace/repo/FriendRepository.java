package com.group.FakeMyspace.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.group.FakeMyspace.models.Friend;

public interface FriendRepository extends CrudRepository <Friend, Long> {
	Friend findByTopEightTrue(boolean topEight);
	List<Friend> findAllByTopEightTrue(boolean topEight);
	List<Friend> findAll();

}
