package com.example.ratemyhike.Service;

import com.example.ratemyhike.Exceptions.EventWithIdAlreadyExists;
import com.example.ratemyhike.Exceptions.EventWithIdDoesntExist;
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
    public Event createNewEvent(Event event) throws EventWithIdAlreadyExists {
        if(!eventRepo.existsById(event.getEventNumber())) return eventRepo.save(event);
        else throw new EventWithIdAlreadyExists();
    }

    @Override
    public Event getEventById(Long id) throws EventWithIdDoesntExist {
        if(eventRepo.existsById(id)) return eventRepo.findEventByEventNumber(id).get();
        else throw new EventWithIdDoesntExist();
    }

    @Override
    public void deleteEvent(Event event) throws EventWithIdDoesntExist{
        if(!eventRepo.existsById(event.getEventNumber())) eventRepo.delete(event);
        else throw new EventWithIdDoesntExist();
    }

    @Override
    public void updateEvent(Long id, Event event) throws EventWithIdDoesntExist{
        if(eventRepo.existsById(id)){
        Event oldEvent = eventRepo.findEventByEventNumber(id).get();
        event.setEventNumber(oldEvent.getEventNumber());
        eventRepo.save(event);}

        else throw new EventWithIdDoesntExist();
    }


}
