package com.cve.cve.Controllers.Administration;



import com.cve.cve.Models.Video;
import com.cve.cve.Services.VedioSercice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VedioController
 */
@Controller
@RequestMapping("/Administration/Videos")
public class AdminVedioController {
    @Autowired 
    private VedioSercice vedioService;


    @GetMapping
    public String getAllVedios(Model model){
        model.addAttribute("videos",vedioService.findAll());
        return "Cve Back office/AllVedios";
    }


    @GetMapping("/Createform")
    public String GetEventForm(Model model){  
        model.addAttribute("video",new Video());
        return "Cve Back office/VedioCreationForm";
    }

    @GetMapping("/Updateform/{id}")
    public String UpdateVideoForm(@PathVariable(required=true) Long id, Model model){  
        if(vedioService.findById(id).isPresent()){
            model.addAttribute("video",vedioService.findById(id).get());
            return "Cve Back office/VedioUpdateForm"; 
        }
        return "redirect:/Administration/Videos";


    }

    

    @PostMapping(value="Add")
    public String addVedio( Video vedio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        vedioService.save(vedio);
        return "redirect:/Administration/Videos";
    }

    @PostMapping(value="Update")
    public String updateVedio(Video vedio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cve Back office/index";
        }
        vedioService.save(vedio);
        return "redirect:/Administration/Videos";
    }
    
    

    
}