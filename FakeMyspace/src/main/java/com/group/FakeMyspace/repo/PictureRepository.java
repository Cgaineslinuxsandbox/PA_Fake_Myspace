package com.group.FakeMyspace.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Picture;
import com.group.FakeMyspace.models.User;

@Repository

public interface PictureRepository extends CrudRepository<Picture, Long>{

	List<Picture> findAllByProduct(User user);
	
	
}
