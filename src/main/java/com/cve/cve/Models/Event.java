package com.cve.cve.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cve.cve.Enumeration.EventType;

import lombok.Data;

/**
 * Event
 */
@Data
@Entity
public class Event {

    @Id
    @GeneratedValue
    private int Id;
    
    private String EventName;
    private String Duration;
    private String Description;
    private String InscriptionLink;
    private String Adress;
    private String AdressGoogleMaps;
    private String PlanningImageLink;
    private Boolean Visible;
    private Date EventDate;
    private Date DateAdd;
    private EventType eventType;

}

