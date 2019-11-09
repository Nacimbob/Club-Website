package com.cve.cve.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * Vedio
 */
@Data
@Entity
public class Vedio {
 
    @Id
    @GeneratedValue
    private int Id;
    private String Title;
    private String Description;
    private String DateAdd;
    private Boolean Visible;
    private String VedioLink;
    
}