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
    private int Id;

    private String username;
    private String Password;

    public User(String username, String encodedPassword) {
        this.username=username;
        this.Password=encodedPassword;
	}
    
    public User(){
        
    }


    
}