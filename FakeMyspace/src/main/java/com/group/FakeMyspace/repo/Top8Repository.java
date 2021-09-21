package com.group.FakeMyspace.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Top8;

@Repository
public interface Top8Repository extends CrudRepository<Top8, Long>{

}
