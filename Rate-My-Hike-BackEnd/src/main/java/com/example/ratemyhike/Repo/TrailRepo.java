package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Model.Trail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TrailRepo extends MongoRepository<Trail,Long> {
}
