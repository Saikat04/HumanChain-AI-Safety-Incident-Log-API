package api.log.incident.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import api.log.incident.com.entity.Incidents;
import api.log.incident.com.services.impl.IncidentServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class AddingIncident {

    @Autowired
    IncidentServiceImpl incidentServiceImpl;
    
    @RequestMapping(value = "/addIncidents", method=RequestMethod.POST)
    public String requestMethodName(@RequestBody Incidents incident) {
        Incidents i = incidentServiceImpl.createIncident(incident);
        System.out.println(i.getIncidentId()+" "+i.getIncidentCreatedAt());
        return "Incident Created Successfully with ID: " + i.getIncidentId();
    }
    /*
     {
        "incidentTitle": "Testing adding method",
        "incidentDescription": "Test Description method",
        "incidentSeverity": "HIGH"
    }
     */
}
