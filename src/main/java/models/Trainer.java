package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    private String name;

    private String email;

    @OneToMany(mappedBy = "trainer")
    private Set<Registration> registrations = new HashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TrainerAvailability> availabilities = new HashSet<>();

    @OneToOne(mappedBy = "trainer")
    private PTSession ptSession;

    @OneToMany(mappedBy = "trainer")
    private Set<Dashboard> dashboards = new HashSet<>();

    public Trainer() {}
    public Trainer(Long trainerId, String name, String email) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
    }


    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAvailability(TrainerAvailability availability) {
        availabilities.add(availability);
        availability.setTrainer(this);
    }

    public void removeAvailability(TrainerAvailability availability) {
        availabilities.remove(availability);
        availability.setTrainer(null);
    }

    public Set<TrainerAvailability> getAvailabilities() {
        return availabilities;
    }

    public PTSession getPtSession() { return ptSession; }
    public void setPtSession(PTSession ptSession) { this.ptSession = ptSession; }

    public void addDashboard(Dashboard dashboard) {
        dashboards.add(dashboard);
        dashboard.setTrainer(this);
    }

    public void removeDashboard(Dashboard dashboard) {
        dashboards.remove(dashboard);
        dashboard.setTrainer(null);
    }

    public Set<Dashboard> getDashboards() { return dashboards; }
}

