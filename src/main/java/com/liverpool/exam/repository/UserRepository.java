package com.liverpool.exam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.liverpool.exam.entity.User;



public interface UserRepository extends MongoRepository<User, String>{

}
