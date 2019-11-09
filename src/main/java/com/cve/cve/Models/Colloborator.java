package com.cve.cve.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cve.cve.Enumeration.CollaboratorType;

import lombok.Data;

/**
 * Colloborator
 */

@Data
@Entity
public class Colloborator {
    @Id
    @GeneratedValue
    private int Id;
    private String Name;
    private String Logo;
    private String Description;
    private boolean Visible;
    public CollaboratorType collaboratorType;

    
}