package com.cve.cve.Controllers.Administration;

import com.cve.cve.Models.Guest;
import com.cve.cve.Services.GuestService;
import com.cve.cve.Services.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * GuestController
 */

@Controller
@RequestMapping("/Administration/Guests")
public class AdminGuestController {


    @Autowired 
    private GuestService guestService;
    @Autowired
    private StorageService storageService;
    
    @GetMapping
    public String GetGuests(Model model){
        model.addAttribute("guests",guestService.findAll());
        return "Cve Back office/AllGuests";

    }
     
    

    @GetMapping("/Createform")
    public String getGuestsForm(Model model){  
        model.addAttribute("guest",new Guest());
        return "Cve Back office/GuestCreationForm";
    }
    
    @PostMapping(value="Add",consumes = {"multipart/form-data"})
    public String addVedio( Guest guest, @RequestParam(value="imageGuest") MultipartFile imageGuest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        guest.setImage(storageService.uploadFile(imageGuest,guest.getId()));
        guestService.save(guest);
        return "redirect:/Administration/Guests";
    }
    
    @GetMapping(value="Updateform/{id}")
    public String updateForm(@PathVariable Long id,Model model ){
       
        if(guestService.findById(id).isPresent()) {
            model.addAttribute("guest",guestService.findById(id).get());
            return "Cve Back office/GuestUpdateForm"; 
        }
        else {
            return "redirect:/Administration/Guests";
        }
    }

    @PostMapping(value="Update")
    public String update( Guest guest, @RequestParam(value="imageGuest",required=false) MultipartFile imageGuest, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        if(!imageGuest.isEmpty()){
            guest.setImage(storageService.uploadFile(imageGuest,guest.getId()));
        }
       
        guestService.save(guest);
        return "redirect:/Administration/Guests";
        
    }
    

    
}