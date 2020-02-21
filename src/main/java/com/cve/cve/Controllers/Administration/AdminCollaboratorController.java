package com.cve.cve.Controllers.Administration;

import com.cve.cve.Models.Collaborator;
import com.cve.cve.Services.CollaboratorService;
import com.cve.cve.Services.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * CollaboratorController
 */
@Controller
@RequestMapping("/Administration/Collaborators")
public class AdminCollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    @Autowired
    private StorageService storageService;

    
   /*
   * 
   *  return global and visible Collaborators ;
   *  Globale collaborators are visible in the welcomePage
   */

    @GetMapping
    private String getCollaborators(Model model){
        
        
        model.addAttribute("collaborators",collaboratorService.findAll());
        return "Cve Back office/AllCollaborators";
    }


    

    @GetMapping("/Createform")
    public String getGuestsForm(Model model){  
        model.addAttribute("collaborator",new Collaborator());
       // model.addAttribute("collaborators",collaboratorService.findAllVisiblCollaborators());
       // model.addAttribute("guests",guestService.findAllVisibleGuests());
        return "Cve Back office/CollaboratorCreationForm";
    }
    
    @PostMapping(value="Add",consumes = {"multipart/form-data"})
    public String addCollaborator( Collaborator collaborator, @RequestParam(value="imageLogo") MultipartFile imageLogo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        collaborator.setLogo(storageService.uploadFile(imageLogo,collaborator.getId()));
        collaboratorService.save(collaborator);
        return "redirect:/Administration/Collaborators";
    }
    
    @GetMapping(value="/Updateform/{id}")
    public String updateCollaborator(@PathVariable Long id,Model model){

        if(collaboratorService.findById(id).isPresent()){
          model.addAttribute("collaborator",collaboratorService.findById(id).get());
          return "Cve Back office/CollaboratorUpdateForm";
        }
        return "redirect:/Administration/Collaborators";
    }
    @PostMapping(value="Update",consumes = {"multipart/form-data"})
    public String updateCollaborator( Collaborator collaborator, @RequestParam(value="imageLogo") MultipartFile imageLogo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        if(!imageLogo.isEmpty()){
            collaborator.setLogo(storageService.uploadFile(imageLogo,collaborator.getId()));
        }
        collaborator.setLogo(storageService.uploadFile(imageLogo,collaborator.getId()));
        collaboratorService.save(collaborator);
        return "redirect:/Administration/Collaborators";
    }

    
}