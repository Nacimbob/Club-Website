package com.cve.cve.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import lombok.Data;

/**
 * User
 */
@Data
@Entity
public class User {

	@Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    public User(String username, String encodedPassword) {
        this.username=username;
        this.password=encodedPassword;
	}
    
    public User(){
        
    }


    
}