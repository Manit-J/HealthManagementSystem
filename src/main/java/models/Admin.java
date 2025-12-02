package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String name;
    private String email;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bill> bills = new HashSet<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoomBooking> roomBookings = new HashSet<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Equipment> equipmentSet = new HashSet<>();

    public Admin() {}
    public Admin(Long adminId, String name, String email) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
    }


    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
        bill.setAdmin(this);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
        bill.setAdmin(null);
    }

    public Set<Bill> getBills() { return bills; }

    public void addRoomBooking(RoomBooking booking) {
        roomBookings.add(booking);
        booking.setAdmin(this);
    }

    public void removeRoomBooking(RoomBooking booking) {
        roomBookings.remove(booking);
        booking.setAdmin(null);
    }

    public Set<RoomBooking> getRoomBookings() { return roomBookings; }

    public void addEquipment(Equipment equipment) {
        equipmentSet.add(equipment);
        equipment.setAdmin(this);
    }

    public void removeEquipment(Equipment equipment) {
        equipmentSet.remove(equipment);
        equipment.setAdmin(null);
    }

    public Set<Equipment> getEquipmentSet() { return equipmentSet; }
}
