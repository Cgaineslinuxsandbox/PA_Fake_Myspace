package com.Jesus.friendmanagement.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Jesus.friendmanagement.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	List<User> findAllByEmail(Set<String> emails);
}
