package com.example.ratemyhike.Service;

import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EventServiceImpl implements EventService{
    @Autowired
    EventRepo eventRepo;

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
