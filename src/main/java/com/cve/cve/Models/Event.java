package com.cve.cve.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.cve.cve.Enumeration.EventType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

/**
 * Event
 */
@Getter
@Setter
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String eventLogo;
    private String eventName;
    private String duration;
    private String description;
    private String inscriptionLink;
    private String adress;
    private String adressGoogleMaps;
    private String planningImageLink;
    private Boolean visible;
    private Boolean inscription;
    @DateTimeFormat(iso = ISO.DATE)
    private Date eventDate;
    @DateTimeFormat(iso = ISO.DATE)
    private Date dateAdd;

    private EventType eventType;

    @ManyToMany(mappedBy="events2",cascade={ CascadeType.MERGE},fetch = FetchType.EAGER)
    private Set<Guest> Guests=new HashSet<>();


    @ManyToMany(mappedBy="events" ,cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    private Set<Collaborator> collaborators = new HashSet<>();
     
    public void addCollaborator(Collaborator collaborator){
        collaborators.add(collaborator);   
        collaborator.getEvents().add(this);
    }

    public void removeCollaborator(Collaborator collaborator){
        collaborator.getEvents().remove(this);
        collaborators.remove(collaborator);   
    }

    public  void removeCollaborators() {
        Iterator setIterator = this.getCollaborators().iterator();
        while(setIterator.hasNext()) {
        Collaborator setItem = (Collaborator) setIterator.next();
             setItem.getEvents().remove(this);
             setIterator.remove();
             System.out.println(setItem + " removed");
         }
   
    } 

    public  void removeGuests() {
        Iterator setIterator = this.getGuests().iterator();
        while(setIterator.hasNext()) {
        Guest setItem = (Guest) setIterator.next();
             setItem.getEvents2().remove(this);
             setIterator.remove();
         }
   
    }




	public void addGuest(Guest guest) {
        this.Guests.add(guest);
        guest.getEvents2().add(this);
    }
}