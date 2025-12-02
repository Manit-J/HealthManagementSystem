package models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    private boolean working;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EquipmentRepair> repairs = new HashSet<>();

    public Equipment() {}
    public Equipment(Long equipmentId, boolean working, Admin admin ) {
        this.equipmentId = equipmentId;
        this.working = working;
        this.admin = admin;
    }


    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }


    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public void addRepair(EquipmentRepair repair) {
        repairs.add(repair);
        repair.setEquipment(this);
    }

    public void removeRepair(EquipmentRepair repair) {
        repairs.remove(repair);
        repair.setEquipment(null);
    }

    public Set<EquipmentRepair> getRepairs() { return repairs; }
}
