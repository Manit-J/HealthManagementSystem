package com.club.models;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomID;

    @Column(name = "room_name", nullable = false, unique = true)
    private String roomName;

    @Column(name = "capacity")
    private Integer capacity;

    //  Many Classes 
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<GroupClasses> classes = new HashSet<>();

    public Room() {}

    public Room(String roomName, Integer capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getRoomID() { return roomID; }
    
    public String getRoomName() { return roomName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}