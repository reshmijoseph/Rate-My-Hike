package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {

    User findUserByUsername(String name);
}