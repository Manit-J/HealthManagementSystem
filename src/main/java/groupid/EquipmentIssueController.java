package groupId;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/admin/issues")
public class EquipmentIssueController {

    @Autowired
    private EquipmentIssueService issueService;

    // Log a new issue
    @PostMapping
    public EquipmentIssue logIssue(@RequestBody EquipmentIssue issue) {
        return issueService.logIssue(issue);
    }

    // View all issues
    @GetMapping
    public List<EquipmentIssue> getAllIssues() {
        return issueService.getAllIssues();
    }

    // Update issue status
    @PutMapping("/{id}/status")
    public EquipmentIssue updateIssueStatus(@PathVariable Long id,
                                            @RequestParam MaintenanceStatus status) {
        return issueService.updateStatus(id, status);
    }

    // get issues by status (OPEN, IN_PROGRESS, FIXED)
    @GetMapping("/status")
    public List<EquipmentIssue> getByStatus(@RequestParam MaintenanceStatus status) {
        return issueService.getByStatus(status);
    }
}
