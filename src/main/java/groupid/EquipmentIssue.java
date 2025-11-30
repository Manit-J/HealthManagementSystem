package groupId;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_issue")
public class EquipmentIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentName;  

    private String roomName;       

    @Column(nullable = false)
    private String issueDescription;

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status = MaintenanceStatus.OPEN;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime resolvedAt;

    public EquipmentIssue() {}

    public EquipmentIssue(String equipmentName, String roomName, String issueDescription) {
        this.equipmentName = equipmentName;
        this.roomName = roomName;
        this.issueDescription = issueDescription;
    }

    public Long getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;

        if (status == MaintenanceStatus.FIXED) {
            this.resolvedAt = LocalDateTime.now();
        }
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }
}

