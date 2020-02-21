package com.cve.cve.Dtos.Responses;

import java.util.Date;

import com.cve.cve.Enumeration.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by Arpit Khandelwal.
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {

    private int Id;
    private String EventName;
    private String Duration;
    private String Description;
    private String InscriptionLink;
    private String Adress;
    private String AdressGoogleMaps;
    private String PlanningImageLink;
    private Date EventDate;
    private EventType eventType;


}
