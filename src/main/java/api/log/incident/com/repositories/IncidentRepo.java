package api.log.incident.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.log.incident.com.entity.Incidents;

public interface IncidentRepo extends JpaRepository<Incidents, Long> {
    
}
