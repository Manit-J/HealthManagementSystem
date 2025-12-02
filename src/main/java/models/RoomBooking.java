package models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="RoomBooking")
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomNo;

    private String type;
    private String bookedFor;
    private LocalDate timestamp;
    private Long adminId;

    public RoomBooking() {}
    public RoomBooking(Long roomNo, String type, String bookedFor, LocalDate timestamp, Long adminId) {
        this.roomNo = roomNo;
        this.type = type;
        this.bookedFor = bookedFor;
        this.timestamp = timestamp;
        this.adminId = adminId;
    }


    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookedFor() {
        return bookedFor;
    }

    public void setBookedFor(String bookedFor) {
        this.bookedFor = bookedFor;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
