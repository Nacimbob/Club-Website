package com.cve.cve.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cve.cve.Models.Guest;
import com.cve.cve.Repositories.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EventService
 */
 @Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update (Guest guest){
        return guestRepository.save(guest);
           
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    } 

    public List<Guest> findAll(){
        return guestRepository.findAll();
    }
    
    public void delete(@Valid Long id){
         guestRepository.deleteById( id);
    }

    public List<Guest> findAllVisibleGuests(){
         return guestRepository.findByVisibleTrue();
    }
    
    public Long countGuest(){
        return  guestRepository.count();
   }
}