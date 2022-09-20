package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AdminRepo extends MongoRepository<Admin, Long> {
}
