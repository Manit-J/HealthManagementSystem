package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TrainerAvailability")
public class TrainerAvailability {

    @Id
    private Long trainerId;

    private String timeSlots; // should be listed for the upcoming week, e.g. M2TO3PM

    private String recurringTimeSlots; // should be listed like timeSlots above

    public TrainerAvailability() {}
    public TrainerAvailability(Long trainerId, String timeSlots, String recurringTimeSlots) {
        this.trainerId = trainerId;
        this.timeSlots = timeSlots;
        this.recurringTimeSlots = recurringTimeSlots;
    }


    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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
