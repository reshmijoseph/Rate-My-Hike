package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepo extends MongoRepository<Event,Long> {
}
