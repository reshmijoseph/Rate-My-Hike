package com.example.ratemyhike.Service;

import com.example.ratemyhike.Exceptions.EventWithIdAlreadyExists;
import com.example.ratemyhike.Exceptions.EventWithIdDoesntExist;
import com.example.ratemyhike.Model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public interface EventService {

    List<Event> getAllEvents();
    Event createNewEvent(Event event) throws EventWithIdAlreadyExists;
    Event getEventById(Long id) throws EventWithIdDoesntExist;

    void deleteEvent(Event event) throws EventWithIdDoesntExist;

    void updateEvent(Long id, Event event) throws EventWithIdDoesntExist;
}
