package com.cve.cve.Controllers.Administration;

import com.cve.cve.Enumeration.CollaboratorType;
import com.cve.cve.Services.CollaboratorService;
import com.cve.cve.Services.EventService;
import com.cve.cve.Services.VedioSercice;
import com.cve.cve.Services.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

class AdminStatistiqueController {

    @Autowired
    private EventService eventService;

    @Autowired
    private VedioSercice vedioService;

    @Autowired 
    private  CollaboratorService  collaboratorService;

    @Autowired 
    private  GuestService  guestService;



    @RequestMapping("/Administration/Statistiques")
    public String Statistiques(Model model){

        model.addAttribute("Sponsor",collaboratorService.CollaboratorsByType(CollaboratorType.Sponsor));
        model.addAttribute("Partner",collaboratorService.CollaboratorsByType(CollaboratorType.Partner));
        model.addAttribute("Activity",eventService.countActivity());
        model.addAttribute("Project",eventService.countProject());
        model.addAttribute("Events",eventService.countEvent());
        model.addAttribute("Guests",guestService.countGuest());
        model.addAttribute("Vedios",vedioService.countVedio());
        model.addAttribute("Collaborators",collaboratorService.countCollaborator());
        return "Cve Back office/pages/Statistique/Statistiques.html";
    }


}