package com.cve.cve.Controllers.Api;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.validation.ValidationException;

import com.cve.cve.Models.User;
import com.cve.cve.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */

 @RestController
public class HelloController {
    @Autowired
    private UserRepository userRepository;
  @RequestMapping({ "/hello" })
  public String FirstPage(){
    return "Hello World";
  }

  @PostMapping("/user")
  public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
      String username = body.get("username");
      if (userRepository.existsByUsername(username)){

          throw new ValidationException("Username already existed");

      }

      String password = body.get("password");
      String encodedPassword = new BCryptPasswordEncoder().encode(password);
      userRepository.save(new User(username, encodedPassword));
      return true;
  }

}