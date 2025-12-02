package models;

import jakarta.persistence.*;

@Entity
@Table(name="TrainerAvailability")
public class TrainerAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // surrogate PK

    private String timeSlots;           // e.g., M2TO3PM
    private String recurringTimeSlots;  // e.g., weekly slots

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    public TrainerAvailability() {}
    public TrainerAvailability(Trainer trainer, String timeSlots, String recurringTimeSlots) {
        this.trainer = trainer;
        this.timeSlots = timeSlots;
        this.recurringTimeSlots = recurringTimeSlots;
    }


    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String getRecurringTimeSlots() {
        return recurringTimeSlots;
    }

    public void setRecurringTimeSlots(String recurringTimeSlots) {
        this.recurringTimeSlots = recurringTimeSlots;
    }
}
