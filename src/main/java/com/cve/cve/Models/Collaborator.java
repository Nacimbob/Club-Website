package com.cve.cve.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.cve.cve.Enumeration.CollaboratorType;
import java.util.HashSet;


/**
 * Colloborator
 */

@Entity
public class Collaborator {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String logo;
    private String description;
    private boolean visible;
    private boolean globale;
    private CollaboratorType collaboratorType;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "event_collaborator", joinColumns = @JoinColumn(name = "collaborator_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events = new HashSet<>();

    public Set<Event> getEvents() {
        return events;
    }

    public void seEvents(Set<Event> events){
        this.events=events;
    }

    public String getName() {
        return name;
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public CollaboratorType getCollaboratorType() {
        return collaboratorType;
    }

    public void setCollaboratorType(CollaboratorType collaboratorType) {
        this.collaboratorType = collaboratorType;
    }

    public boolean isGlobale() {
        return globale;
    }

    public void setGlobale(boolean globale) {
        this.globale = globale;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    

    
}