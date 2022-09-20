package com.example.ratemyhike.Service;

import com.example.ratemyhike.Model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface EventService {

    List<Event> getAllEvents();
    Event createNewEvent();
    Event getEventById();
}
