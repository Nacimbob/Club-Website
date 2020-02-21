package com.cve.cve.Controllers.Api;

import java.util.ArrayList;
import java.util.List;

import com.cve.cve.Dtos.Responses.GuestDto;
import com.cve.cve.Services.EventService;
import com.cve.cve.Services.GuestService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GuestController
 */


@RestController
@RequestMapping("/Api/Guests")
public class GuestController {

    @Autowired 
    private ModelMapper modelMapper;
    
    @Autowired 
    private GuestService guestService;
    @Autowired 
    private EventService eventService;
    @GetMapping("/All")
    public ResponseEntity<List<GuestDto>> getAll() {
        List<GuestDto> listEventDto=new ArrayList<>();
        ModelMapper modelMapper2 = modelMapper;
       modelMapper2.map(guestService.findAll(),listEventDto);
       return ResponseEntity.ok(listEventDto);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity getEvent(@PathVariable Long id){
     return ResponseEntity.ok(modelMapper.map(guestService.findById(id), GuestDto.class));         
    }

    @GetMapping("/Event/{id}")
    public ResponseEntity getGuestByEvent(@PathVariable Long id){
        if(eventService.findById(id).isPresent()){
            List<GuestDto> listGuestDto= modelMapper.map(eventService.findById(id).get().getGuests(),new TypeToken<List<GuestDto>>() {}.getType());
            return ResponseEntity.ok(listGuestDto);  
        }
        return ResponseEntity.ok( new  GuestDto()); 
       
    }
    
    
    
}