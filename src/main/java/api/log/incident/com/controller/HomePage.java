package api.log.incident.com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HomePage {
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String homePage() {
        return "Welcome to the Incident Management System API!";
    }
    
}
