package com.garvintimothy.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.garvintimothy.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional<User> findByEmail(String search);
	
	Optional<User> findByName(String search);
}
