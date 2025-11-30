package groupId;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupClassService {

    private final GroupClassRepository classRepo;
    private final TrainerRepository trainerRepo;

    public GroupClassService(GroupClassRepository classRepo, TrainerRepository trainerRepo) {
        this.classRepo = classRepo;
        this.trainerRepo = trainerRepo;
    }

    public GroupClass createClass(GroupClass groupClass) {
        return classRepo.save(groupClass);
    }

    public GroupClass updateClass(Long id, GroupClass updated) {
        GroupClass existing = classRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        existing.setClassName(updated.getClassName());
        existing.setRoom(updated.getRoom());
        existing.setScheduledTime(updated.getScheduledTime());
        existing.setTrainer(updated.getTrainer());

        return classRepo.save(existing);
    }

    public List<GroupClass> getAllClasses() {
        return classRepo.findAll();
    }
}

