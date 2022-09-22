package com.example.ratemyhike.Repo;

import com.example.ratemyhike.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface EventRepo extends MongoRepository<Event, Long> {

    Optional<Event> findEventByEventNumber(Long eventNumber);
}
