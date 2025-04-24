package api.log.incident.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.log.incident.com.entity.Incidents;
import api.log.incident.com.services.impl.IncidentServiceImpl;


@RestController
public class SearchIncident {

    @Autowired
    IncidentServiceImpl incidentServiceImpl;

    @RequestMapping(value = "/searchByIcidentId/{id}", method=RequestMethod.GET)
    public Incidents searchByIcidentId(@PathVariable("id") Long id) {
        return incidentServiceImpl.getIncidentById(id);        
    }
    

    @RequestMapping(value = "/searchAllIncidents", method=RequestMethod.GET)
    public List<Incidents> searchIncidents() {
        return incidentServiceImpl.getAllIncidents();
    }
}
