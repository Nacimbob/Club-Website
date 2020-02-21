package com.cve.cve.Dtos.Requests;

import java.io.Serializable;
import com.cve.cve.Models.Event;

import lombok.Data;
@Data
public class EventDto implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;
    private Event event;
    
    private String[] colla;



  


}