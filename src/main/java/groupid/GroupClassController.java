package groupId;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/classes")  // only accessibale by admin
public class GroupClassController {

    private final GroupClassService classService;

    public GroupClassController(GroupClassService classService) {
        this.classService = classService;
    }

    // create new class
    @PostMapping
    public GroupClass createClass(@RequestBody GroupClass groupClass) {
        return classService.createClass(groupClass);
    }

    // update schedule, trainer, or room
    @PutMapping("/{id}")
    public GroupClass updateClass(@PathVariable Long id, @RequestBody GroupClass updated) {
        return classService.updateClass(id, updated);
    }

    // list classes
    @GetMapping
    public List<GroupClass> getAll() {
        return classService.getAllClasses();
    }
}
