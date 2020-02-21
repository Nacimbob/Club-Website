package com.cve.cve.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cve.cve.Enumeration.CollaboratorType;
import com.cve.cve.Enumeration.EventType;
import com.cve.cve.Models.Event;
import com.cve.cve.Repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventService
 */
 @Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    
    
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void update (Event event,Long id){
        if(eventRepository.findById(id).isPresent()){
            Event updateEvent=eventRepository.findById(id).get();
            updateEvent.removeCollaborators();
            //updateEvent.removeGuests();
            eventRepository.save(updateEvent);
            eventRepository.save(event);
            
        }
           
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    } 

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public List<Event> findAllVisibleEvents(){
        return eventRepository.findByVisibleTrue();
    }
    
    public void delete(@Valid Long id){
         eventRepository.deleteById( id);
    }
    
    public Long countEvent(){
         return  eventRepository.count();
    }

    public Long countActivity(){
        return  eventRepository.countByEventType(EventType.Activity);
    }

    public Long countProject(){
     return  eventRepository.countByEventType(EventType.Project);
    }





}