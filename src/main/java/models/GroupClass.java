package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GroupClass")
public class GroupClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classID;

    private String className;

    private LocalDateTime timestamp;

    private int capacity;

    @ManyToMany(mappedBy = "registeredClasses")
    private List<Member> registeredMembers = new ArrayList<>();

    public GroupClass() {
    }

    public GroupClass(String className, LocalDateTime timestamp, int capacity) {
        this.className = className;
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