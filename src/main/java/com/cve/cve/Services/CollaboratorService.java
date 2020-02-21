package com.cve.cve.Services;

import java.util.List;
import java.util.Optional;

import com.cve.cve.Enumeration.CollaboratorType;
import com.cve.cve.Models.Collaborator;
import com.cve.cve.Repositories.CollaboratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CollaboratorService
 */
@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;
    
    public Collaborator save(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    public Collaborator update (Collaborator collaborator ){
        return collaboratorRepository.save(collaborator);
           
    }

    public Optional<Collaborator> findById(Long i) {
        return collaboratorRepository.findById(i);
    } 
    /*
     find all vedios
    */ 
    
    public List<Collaborator> findAll(){
        return collaboratorRepository.findAll();
    }

    public List<Collaborator> findAllVisiblCollaborators(){
        return collaboratorRepository.findByVisibleTrue();
    }
    
   /*
   *   la liste des 
   * 
   *      
   */

    public List<Collaborator> findAllVisibleGlobaleCollaborators(){
        return collaboratorRepository.findByVisibleTrueAndGlobaleTrue();
    }
      /*
          find ccollaborators by eventi_d
      */
    public List<Collaborator> findAllCollaboratorsByEvent(Long id){
        return collaboratorRepository.findByVisibleTrueAndGlobaleTrueAndEvents_Id(id);
    }

    public Long countCollaborator(){
        return collaboratorRepository.count();
    }

    public Long CollaboratorsByType(CollaboratorType collaboratorType){
        return  collaboratorRepository.countByCollaboratorType(collaboratorType);
       }
}