package com.example.ratemyhike.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

@Document(collection = "Events")
public class Event {

    @Id
    private AtomicLong eventNumber = new AtomicLong(0);
    private String eventName;
    private String date; //Might need to set a formatter or force the format through the front.
    private String time;
    private String location;

    public Event(){
        this.eventNumber.getAndIncrement();
    }

    public Event(String eventName, String date, String location){
        this.eventNumber.getAndIncrement();
        this.eventName=eventName;
        this.date=date;
        this.location=location;
    }

    public Long getEventNumber(){
        return this.eventNumber.get();
    }

    public void setEventNumber(Long id) {this.eventNumber.set(id);}
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
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
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
