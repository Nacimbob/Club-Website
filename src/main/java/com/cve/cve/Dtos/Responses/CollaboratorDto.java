package com.cve.cve.Dtos.Responses;

import com.cve.cve.Enumeration.CollaboratorType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * CollaboratorDto
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollaboratorDto {
    private int id;
    private String name;
    private String logo;
    private String description;
    private boolean globale;
    private CollaboratorType collaboratorType;
}