package api.log.incident.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.log.incident.com.entity.Incidents;

@Repository
public interface IncidentRepo extends JpaRepository<Incidents, Long> {
    
}
