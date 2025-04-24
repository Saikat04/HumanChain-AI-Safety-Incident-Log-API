package api.log.incident.com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.log.incident.com.entity.Incidents;
import api.log.incident.com.repositories.IncidentRepo;
import api.log.incident.com.services.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService{

    @Autowired
    private IncidentRepo incidentRepo;

    @Override
    public Incidents createIncident(Incidents incident) {
        return incidentRepo.save(incident);
    }

    @Override
    public List<Incidents> getAllIncidents() {
        return incidentRepo.findAll(); // Implementing the method to retrieve all incidents
    }

    @Override
    public Incidents getIncidentById(Long id) {
        return incidentRepo.findById(id).orElseThrow(() -> new RuntimeException("Incident not found")); // Implementing the method to retrieve an incident by its ID
    }

    @Override
    public void deleteIncident(Long id) {
        Incidents existingIncident = incidentRepo.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
        incidentRepo.delete(existingIncident); // Implementing the method to delete an incident by its ID
    }

}
