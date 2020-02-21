package com.cve.cve.Controllers.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomErrorController
 */
@Controller
public class CustomErrorController implements ErrorController {


@RequestMapping("/error")
public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
     
    if (status != null) {
        Integer statusCode = Integer.valueOf(status.toString());
     
        if(statusCode == HttpStatus.NOT_FOUND.value()) {
            return "Cve Back office/Errors/404";
        }
        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "Cve Back office/Errors/500";
        }
    }
     return "Cve Back office/Errors/error";
}

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "/error";
    }

    
}