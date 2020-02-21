package com.cve.cve.Controllers.Administration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class AdminLogin {
    
    @RequestMapping("/login")  
    public String login() {  
        return "Cve Back office/login.html";  
    }  
    // Login form with error  
    @RequestMapping("/login-error")  
    public String loginError(Model model) {  
        model.addAttribute("loginError", true);  
        return "Cve Back office/login.html";    
    } 
}