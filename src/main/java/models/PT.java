package models;

import jakarta.persistence.*;

@Entity
@Table(name="PT")
public class PT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // surrogate PK for PT

    private Long sessionId;   // id of PT session (domain value)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_id", nullable = false)
    private Dashboard dashboard;

    public PT(){}

    public PT(Long sessionId) { this.sessionId = sessionId; }

    // getters/setters
    public Long getId() { return id; }
    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public Dashboard getDashboard() { return dashboard; }
    public void setDashboard(Dashboard dashboard) { this.dashboard = dashboard; }
}
