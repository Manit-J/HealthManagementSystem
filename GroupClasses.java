package com.club.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_classes")
public class GroupClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classID;

    @Column(name = "class_name")
    private String className;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    // Many Classes
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // Many Members
    @ManyToMany(mappedBy = "attendedClasses", fetch = FetchType.LAZY)
    private Set<Member> members = new HashSet<>();

    public GroupClasses() {}

    public GroupClasses(String className, LocalDateTime startTime, LocalDateTime endTime, Room room) {
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
    }

    public Long getClassID() { return classID; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}