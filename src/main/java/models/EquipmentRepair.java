package models;

import jakarta.persistence.Id;

public class EquipmentRepair {

    @Id
    private Long equipmentId;
    private String issue;
    private String repairTask;

    public EquipmentRepair() {}
    public EquipmentRepair(Long equipmentId, String issue, String repairTask) {
        this.equipmentId = equipmentId;
        this.issue = issue;
        this.repairTask = repairTask;
    }


    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getRepairTask() {
        return repairTask;
    }

    public void setRepairTask(String repairTask) {
        this.repairTask = repairTask;
    }
}
