package com.group.FakeMyspace.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Friend;
import com.group.FakeMyspace.models.User;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long>{
	
	List<Friend> findAllByOwner(User owner);

}
