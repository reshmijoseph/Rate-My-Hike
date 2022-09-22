package com.example.ratemyhike.Service;

import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service

public class EventServiceImpl implements EventService{
    @Autowired
    EventRepo eventRepo;

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event createNewEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepo.findEventByEventNumber(id).get();
    }

    @Override
    public void deleteEvent(Event event){
        eventRepo.delete(event);
    }

    @Override
    public void updateEvent(Long id, Event event) {
        Event oldEvent = eventRepo.findEventByEventNumber(id).get();
        event.setEventNumber(oldEvent.getEventNumber());
        eventRepo.save(event);
    }


}
