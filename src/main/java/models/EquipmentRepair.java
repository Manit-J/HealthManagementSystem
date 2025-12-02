package models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "EquipmentRepair")
public class EquipmentRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issue;
    private String repairTask;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    public EquipmentRepair() {}

    public EquipmentRepair(String issue, String repairTask, Equipment equipment) {
        this.issue = issue;
        this.repairTask = repairTask;
        this.equipment = equipment;
    }

    public Long getId() { return id; }

    public String getIssue() { return issue; }
    public void setIssue(String issue) { this.issue = issue; }

    public String getRepairTask() { return repairTask; }
    public void setRepairTask(String repairTask) { this.repairTask = repairTask; }

    public Equipment getEquipment() { return equipment; }
    public void setEquipment(Equipment equipment) { this.equipment = equipment; }
}
