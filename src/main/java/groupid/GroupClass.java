package groupId;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_class")
public class GroupClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private LocalDateTime scheduledTime;

    public GroupClass() {}

    public GroupClass(String className, Trainer trainer, String room, LocalDateTime scheduledTime) {
        this.className = className;
        this.trainer = trainer;
        this.room = room;
        this.scheduledTime = scheduledTime;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public String getRoom() {
        return room;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    
}
