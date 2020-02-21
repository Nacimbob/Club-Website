package com.cve.cve.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

/**
 * Vedio
 */
@Data
@Entity
public class Video {
 
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private Boolean visible;
    private String vedioLink;
    @PrePersist
    @Column(nullable=false)
    protected void onCreate() {
      created = new Date();
    }
   
    @PreUpdate
    protected void onUpdate() {
      updated = new Date();

    }
    
}