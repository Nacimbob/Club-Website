package com.cve.cve.Controllers.Api;

import java.util.List;

import com.cve.cve.Dtos.Responses.CollaboratorDto;
import com.cve.cve.Services.CollaboratorService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * CollaboratorController
 */
@RestController
@RequestMapping("/Api/Collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;
    @Autowired
    private ModelMapper modelMapper;
  
    
   /*
   * 
   *  return global and visible Collaborators ;
   *  Globale collaborators are visible in the welcomePage
   */

    @GetMapping("/All")
    private ResponseEntity getGlobaleCollaborators(){
        List<CollaboratorDto> listCollaboratorDto= modelMapper.map(collaboratorService.findAllVisibleGlobaleCollaborators(),new TypeToken<List<CollaboratorDto>>() {}.getType());
        return ResponseEntity.ok(listCollaboratorDto); 
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CollaboratorDto> getEvent(@PathVariable Long id){
      if(collaboratorService.findById(id).isPresent()){
       return ResponseEntity.ok(modelMapper.map(collaboratorService.findById(id).get(), CollaboratorDto.class));  
      }
      return new ResponseEntity<>(HttpStatus.OK); 
    }



    @GetMapping(value="/Event/{id}")
    public ResponseEntity getEventCollaborators(@PathVariable Long id) {

        List<CollaboratorDto> listCollaboratorDto= modelMapper.map(collaboratorService.findAllCollaboratorsByEvent(id),new TypeToken<List<CollaboratorDto>>() {}.getType());
        return ResponseEntity.ok(listCollaboratorDto);  
        
    }
    

    
}