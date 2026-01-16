package com.liverpool.exam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.liverpool.exam.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
