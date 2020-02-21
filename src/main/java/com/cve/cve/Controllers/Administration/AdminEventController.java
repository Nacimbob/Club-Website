package com.cve.cve.Controllers.Administration;

import com.cve.cve.Models.Collaborator;
import com.cve.cve.Models.Event;
import com.cve.cve.Models.Guest;
import com.cve.cve.Services.CollaboratorService;
import com.cve.cve.Services.EventService;
import com.cve.cve.Services.GuestService;
import com.cve.cve.Services.StorageService;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * VedioController
 */
@Controller
@RequestMapping("/Administration/Events")
public class AdminEventController {
    @Autowired 
    private EventService eventService;

    @Autowired
    private StorageService storageService;

    @Autowired 
    private CollaboratorService collaboratorService;

    @Autowired 
    private GuestService guestService;
    /*
    get all vedios where visible=true
    */ 

    @GetMapping
    public String GetEvents(Model model){
      
        model.addAttribute("events",eventService.findAll());

        return "Cve Back office/cards";
    }


    @GetMapping("/Createform")
    public String GetEventForm(Model model){  
        model.addAttribute("event",new Event());
        model.addAttribute("collaborators",collaboratorService.findAllVisiblCollaborators());
        model.addAttribute("guests",guestService.findAllVisibleGuests());
        return "Cve Back office/EventCreationForm";
    }


    @GetMapping("/Updateform/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        if(eventService.findById(id).isPresent()){
            Event event = eventService.findById(id).get();
            List<Collaborator> Allcollaborators=collaboratorService.findAllVisiblCollaborators();
            model.addAttribute("event", event);
                for (Collaborator tofind : event.getCollaborators() ) {
                    ListIterator<Collaborator> iter = Allcollaborators.listIterator();
                    while(iter.hasNext()){
                    if(iter.next().getId()==tofind.getId()){
                        iter.remove();
                    }
                 }
             }
             List<Guest> Allguests=guestService.findAllVisibleGuests();
             model.addAttribute("event", event);
                 for (Guest tofind : event.getGuests() ) {
                     ListIterator<Guest> iter = Allguests.listIterator();
                     while(iter.hasNext()){
                     if(iter.next().getId()==tofind.getId()){
                         iter.remove();
                     }
                  }
              }
            model.addAttribute("collaborators",Allcollaborators);
            model.addAttribute("guests",Allguests);
            return "Cve Back office/EventUpdateForm";
        }
        return "Cve Back office/EventCreationForm";
    }


    @PostMapping(value="Add",consumes = {"multipart/form-data"})
    public String addEvent(
        @ModelAttribute Event event,
        @RequestParam(value="colla",defaultValue="",required=false) String[] colla,
        @RequestParam(value="guests", defaultValue="",required=false) String[] guests,
        @RequestParam(value="imageplanning") MultipartFile imageplanning,
        @RequestParam(value="logoEvent") MultipartFile logoEvent,
         BindingResult result, Model model) {
        if (result.hasErrors()) {

             return "redirect:/Administration/Events/form";
        }
        getEventGuests(guests, event);
        getEventCollaborators(colla,event);
        getEventGuests(guests, event);
        System.out.println(event.getCollaborators());
        event.setEventLogo(storageService.uploadFile(logoEvent,event.getId()));
        event.setPlanningImageLink(storageService.uploadFile(imageplanning,event.getId()));
        eventService.save(event);
        model.addAttribute("events",eventService.findAll());
        return "redirect:/Administration/Events";
    }
    


    @PostMapping(value="Update/{id}",consumes = {"multipart/form-data"})
    public String updateEvent(
        @PathVariable("id") long id,
        @ModelAttribute Event event,
        @RequestParam(value="colla", defaultValue="",required=false) String[] colla,
        @RequestParam(value="Guests", defaultValue="",required=false) String[] guests,
        @RequestParam(value="imageplanning") MultipartFile imageplanning,
        @RequestParam(value="logoEvent") MultipartFile logoEvent,
         BindingResult result, Model model) {
        if (result.hasErrors()) {
             return "redirect:/Adminsistration/Events/form";
        }
        

        eventService.findById(id).get().removeCollaborators();
        eventService.findById(id).get().removeGuests();
        eventService.save(eventService.findById(id).get());
        getEventCollaborators(colla,event);
        getEventGuests(guests, event);
        if(!logoEvent.isEmpty()){
            event.setEventLogo(storageService.uploadFile(logoEvent,event.getId()));
        }
        if(!imageplanning.isEmpty()){
            event.setPlanningImageLink(storageService.uploadFile(imageplanning,event.getId()));
        }


        eventService.save(event);
        model.addAttribute("events",eventService.findAll());
        return "redirect:/Administration/Events";
        
    }
    
   

    public  void getEventCollaborators(String[] collaboratorsStrings,Event event) {
        for (String string : collaboratorsStrings) {
            if(collaboratorService.findById(Long.parseLong(string)).isPresent() ){
                event.addCollaborator(collaboratorService.findById(Long.parseLong(string)).get());
            }

        }
    } 




    public  void getEventGuests(String[] guestsStrings,Event event) {
        for (String string : guestsStrings) {
            if(guestService.findById(Long.parseLong(string)).isPresent() ){
                event.addGuest(guestService.findById(Long.parseLong(string)).get());
            }

        }
    } 

    public void removeRelated(){
        
        

    }
    


     

    
}