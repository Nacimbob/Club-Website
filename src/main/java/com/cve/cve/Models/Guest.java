package com.cve.cve.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * Guest
 */
@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue
    private int Id;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private String Image;
    private String Description;
    private boolean Visible;
    private Date DateAdd;
    
}