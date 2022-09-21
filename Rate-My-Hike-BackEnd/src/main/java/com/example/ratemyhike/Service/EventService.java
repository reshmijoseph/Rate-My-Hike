package com.example.ratemyhike.Service;

import com.example.ratemyhike.Model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public interface EventService {

    List<Event> getAllEvents();
    Event createNewEvent(Event event);
    Event getEventById(Long id);

    void deleteEvent(Event event);

    void updateEvent(Long id, Event event);
}
