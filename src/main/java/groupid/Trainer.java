package groupId;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer {

   
    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private Long trainerId;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String gender;

    // Availability
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Availability> availabilitySlots = new ArrayList<>();

    // Trainer -> PT Sessions (One Trainer has Many PT sessions)
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PTSession> personalTrainingSessions = new ArrayList<>();

    // Trainer -> GroupClasses (One trainer teaches many group classes)
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<GroupClass> groupClasses = new ArrayList<>();


    
    public Trainer() {
    }

    public Trainer(String name, String email, String gender) {
        this.name = name;
        setEmail(email);
        setGender(gender);
    }


    public Long getTrainerId() {
        return trainerId;
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

    // email validation
    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender.toLowerCase();
        if (!gender.equals("male") && !gender.equals("female") && !gender.equals("other")) {
            throw new IllegalArgumentException("Gender must be male, female, or other.");
        }
        this.gender = gender;
    }

    
    public List<Availability> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public List<PTSession> getPersonalTrainingSessions() {
        return personalTrainingSessions;
    }

    public List<GroupClass> getGroupClasses() {
        return groupClasses;
    }

    

    // Add an availability slot (validating overlap)
    public void addAvailabilitySlot(Availability slot) {
        for (Availability existing : availabilitySlots) {
            if (existing.overlaps(slot)) {
                throw new IllegalArgumentException("Availability slot overlaps with existing availability.");
            }
        }
        slot.setTrainer(this);
        availabilitySlots.add(slot);
    }

    // Remove availability
    public void removeAvailabilitySlot(Availability slot) {
        availabilitySlots.remove(slot);
        slot.setTrainer(null);
    }

    // Assign PT session
    public void addPTSession(PTSession session) {
        session.setTrainer(this);
        personalTrainingSessions.add(session);
    }

    // Remove PT session
    public void removePTSession(PTSession session) {
        personalTrainingSessions.remove(session);
        session.setTrainer(null);
    }

    // Assign group class
    public void addGroupClass(GroupClass groupClass) {
        groupClass.setTrainer(this);
        groupClasses.add(groupClass);
    }

    // remove group class
    public void removeGroupClass(GroupClass groupClass) {
        groupClasses.remove(groupClass);
        groupClass.setTrainer(null);
    }

    
    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", availabilityCount=" + availabilitySlots.size() +
                ", ptSessionCount=" + personalTrainingSessions.size() +
                ", groupClassCount=" + groupClasses.size() +
                '}';
    }
}
