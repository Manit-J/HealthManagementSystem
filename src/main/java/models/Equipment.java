package models;

import jakarta.persistence.Id;

public class Equipment {

    @Id
    private Long equipmentId;

    private boolean working;
    private Long adminId;

    public Equipment() {}
    public Equipment(Long equipmentId, boolean working, Long adminId) {
        this.equipmentId = equipmentId;
        this.working = working;
        this.adminId = adminId;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
