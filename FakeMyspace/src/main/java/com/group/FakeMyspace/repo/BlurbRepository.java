package com.group.FakeMyspace.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FakeMyspace.models.Blurb;

@Repository
public interface BlurbRepository extends CrudRepository<Blurb, Long>{

}
