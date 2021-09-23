package com.group.FakeMyspace.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Friend;
import com.group.FakeMyspace.models.User;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long>{
	
	List<Friend> findAllByOwner(User owner);
	
	List<Friend> findAll();
	
//	List<Friend> findAllByOwnerAndSort(User owner, Sort.by("topEight"));   //Try to convert the boolean to int and sort by desc
	
//	List<Friend> findAllByOwnerAndTopEightTrueDesc(User owner, boolean topEight);   //Try to sort the friend list by desc order of boolean
	
<<<<<<< HEAD
//	List<Friend> findAllByOwnerAndTopEightTrue(User owner, boolean topEight);
=======
	List<Friend> findAllByOwnerAndTopEightTrue(User owner);
>>>>>>> dfbec0ee0adca766eef871d84a0d5d60aa489e13
	
	


}
