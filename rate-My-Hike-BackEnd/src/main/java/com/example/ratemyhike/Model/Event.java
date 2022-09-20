package com.example.ratemyhike.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Document
public class Event {

    @Id
    private AtomicLong eventNumber = new AtomicLong();
    private String eventName;
    private String date; //Might need to set a formatter or force the format through the front.
    private String time;
    private String location;

    public Event(){}

    public Event(String eventName, String date, String location){
        this.eventNumber.getAndIncrement();
        this.eventName=eventName;
        this.date=date;
        this.location=location;
    }

    public Long getEventNumber(){
        return this.eventNumber.get();
    }
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public String getDate() {
        return date;
    }

    public LocalDateTime formattedDateTime() {
        String date = getDate();
        String time = getTime();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        return LocalDateTime.parse(date+"T"+time, format);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
