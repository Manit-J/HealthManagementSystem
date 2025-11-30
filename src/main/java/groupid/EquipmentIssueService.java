package groupId;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class EquipmentIssueService {

    @Autowired
    private EquipmentIssueRepository issueRepository;

    public EquipmentIssue logIssue(EquipmentIssue issue) {
        return issueRepository.save(issue);
    }

    public List<EquipmentIssue> getAllIssues() {
        return issueRepository.findAll();
    }

    public EquipmentIssue updateStatus(Long id, MaintenanceStatus status) {
        EquipmentIssue issue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        issue.setStatus(status);
        return issueRepository.save(issue);
    }

    public List<EquipmentIssue> getByStatus(MaintenanceStatus status) {
        return issueRepository.findByStatus(status);
    }
}
