package models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="GroupClass")
public class GroupClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classID;

    private String className;

    private LocalDateTime timestamp;

    private int capacity;

    @ManyToMany(mappedBy = "classes")
    private Set<Member> members = new HashSet<>();

    @OneToMany(mappedBy = "groupClass")
    private Set<Registration> registrations = new HashSet<>();


    public GroupClass() {}
    public GroupClass(Long classId, LocalDate timestamp, int capacity) {
        this.classId = classId;
        this.timestamp = timestamp;
        this.capacity = capacity;
    }

    public Long getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Member> getRegisteredMembers() {
        return registeredMembers;
    }

    public void setRegisteredMembers(List<Member> registeredMembers) {
        this.registeredMembers = registeredMembers;
    }

    public void printDetails() {
        System.out.println("Class ID: " + classID + " | Name: " + className + " | Capacity: " + capacity);
    }
}