package groupId;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipmentIssueRepository extends JpaRepository<EquipmentIssue, Long> {

    List<EquipmentIssue> findByStatus(MaintenanceStatus status);
}

