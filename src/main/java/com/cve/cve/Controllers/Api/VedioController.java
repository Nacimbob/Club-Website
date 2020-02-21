package com.cve.cve.Controllers.Api;

import com.cve.cve.Services.VedioSercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * VedioController
 */
@RestController
@RequestMapping("/Api/Vedios")
public class VedioController {
    @Autowired 
    private VedioSercice vedioService;

    /*
    get all vedios where visible=true
    */
     
    @GetMapping("/All") 
    public ResponseEntity getAll(){
       // List<GuestDto> listGuestDto= modelMapper.map(eventService.findById(id).get().getGuestList(),new TypeToken<List<GuestDto>>() {}.getType());
        return ResponseEntity.ok(vedioService.findAllVisiblVedios());  


    }

    @GetMapping(value="/{id}")
    public ResponseEntity getVedioById(@RequestParam Long id) {
        return ResponseEntity.ok(vedioService.findById(id)); 
    }
    


     

    
}