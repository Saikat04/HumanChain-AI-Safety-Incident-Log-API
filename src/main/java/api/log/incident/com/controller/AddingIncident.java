package api.log.incident.com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import api.log.incident.com.entity.Incidents;
import api.log.incident.com.services.impl.IncidentServiceImpl;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class AddingIncident {

    @Autowired
    IncidentServiceImpl incidentServiceImpl;
    
    @RequestMapping(value = "/addIncidents", method=RequestMethod.POST)
    public ResponseEntity<Map<String, String>> requestMethodName(@Valid @RequestBody Incidents incident) {
        Incidents i = incidentServiceImpl.createIncident(incident);
        return ResponseEntity.ok(Map.of("message", "Incident with ID: " + i.getIncidentId() + " added successfully."));
    }
    /*
     {
        "incidentTitle": "Testing adding method",
        "incidentDescription": "Test Description method",
        "incidentSeverity": "HIGH"
    }
     */
}
