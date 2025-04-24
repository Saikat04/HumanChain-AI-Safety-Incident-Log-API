package api.log.incident.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.log.incident.com.services.impl.IncidentServiceImpl;

@RestController
public class DeleteIncident {

    @Autowired
    IncidentServiceImpl incidentServiceImpl;
    
    @RequestMapping(value = "/deleteIncident/{id}", method=RequestMethod.DELETE)
    public String deleteIncident(@PathVariable("id") Long id) {
        incidentServiceImpl.deleteIncident(id);
        return "Incident with ID: " + id + " deleted successfully.";
    }
}
