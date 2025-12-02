package models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="GroupClass")
public class GroupClass {

    @Id
    private Long classId;

    private LocalDate timestamp;
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


    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
