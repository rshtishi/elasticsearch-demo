package com.github.rshtishi.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.rshtishi.demo.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
	
	List<Person> findAll();

}
