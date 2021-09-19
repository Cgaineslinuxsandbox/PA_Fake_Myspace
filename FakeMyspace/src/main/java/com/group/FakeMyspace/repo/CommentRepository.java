package com.group.FakeMyspace.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Comment;


@Repository
public interface CommentRepository  extends CrudRepository<Comment, Long>{
	List<Comment> findAll();

}
