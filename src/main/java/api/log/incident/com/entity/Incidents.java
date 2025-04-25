package api.log.incident.com.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "incidents")
@Table(name = "incidents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Incidents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IncidentID", nullable = false, unique = true)
    private Long incidentId;

    @NotEmpty
    @Column(name = "IncidentTitle", nullable = false, columnDefinition = "TEXT")
    private String incidentTitle;

    @NotEmpty(message = "Incident Description cannot be empty")
    @Column(name = "IncidentDescription", nullable = false, columnDefinition = "TEXT")
    private String incidentDescription;

    @NotNull(message = "Incident Severity cannot be null")
    @Enumerated(EnumType.STRING) 
    @Column(name = "IncidentSeverity", nullable = false)       
    private Severity incidentSeverity;

    @CreationTimestamp
    @Column(name = "IncidentCreatedAt", nullable = false, updatable = false)
    private LocalDateTime incidentCreatedAt;
}
