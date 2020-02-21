package com.cve.cve.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Guest
 */
@Getter
@Setter
@Entity
public class Guest {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String profile;
    private String image;
    private String description;
    private boolean visible;
    private Date dateAdd;
    
 

    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinTable(name="event_Guest",joinColumns = @JoinColumn(name="guest_id"),inverseJoinColumns = @JoinColumn(name="event_id"))
    private Set<Event> events2 =new HashSet<>();
}