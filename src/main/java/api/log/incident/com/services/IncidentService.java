package api.log.incident.com.services;

import java.util.List;

import api.log.incident.com.entity.Incidents;

public interface IncidentService {
    // Method to create a new incident
    Incidents createIncident(Incidents incident);

    // Method to retrieve all incidents
    List<Incidents> getAllIncidents();

    // Method to retrieve an incident by its ID
    Incidents getIncidentById(Long id);

    // Method to delete an incident by its ID
    void deleteIncident(Long id);
}
