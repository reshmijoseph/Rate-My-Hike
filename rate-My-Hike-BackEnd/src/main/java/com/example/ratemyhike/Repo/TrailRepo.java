package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrailRepo extends MongoRepository<Event,Long> {
}
