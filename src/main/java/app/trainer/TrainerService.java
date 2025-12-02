package apps.trainer;

import groupId.*;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepo;
    private final MemberRepository memberRepo;
    private final AvailabilityRepository availabilityRepo;

    public TrainerService(TrainerRepository trainerRepo,
                          MemberRepository memberRepo,
                          AvailabilityRepository availabilityRepo) {

        this.trainerRepo = trainerRepo;
        this.memberRepo = memberRepo;
        this.availabilityRepo = availabilityRepo;
    }

    // Set availability with overlap prevention
    public Availability addAvailability(Long trainerId, Availability slot) {

        Trainer trainer = trainerRepo.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainer.addAvailabilitySlot(slot);

        Availability saved = availabilityRepo.save(slot);

        System.out.println("Added availability:");
        System.out.println("Trainer: " + trainer.getName());
        System.out.println("Start: " + saved.getStartTime());
        System.out.println("End: " + saved.getEndTime());

        return saved;
    }

    // Member lookup (case-insensitive)
    public Member lookupMember(String name) {

        Member found = memberRepo.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Member not found: " + name));

        System.out.println("LOOKUP RESULT ->");
        System.out.println("Member: " + found.getName());
        System.out.println("Goal: " + found.getFitnessGoal());
        System.out.println("Last Metric: " + found.getLastMetric());

        return found;
    }
}
