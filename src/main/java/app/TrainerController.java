package app;

import groupId.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    // Add availability
    @PostMapping("/{id}/availability")
    public Availability addAvailability(
            @PathVariable Long id,
            @RequestBody Availability slot) {

        return trainerService.addAvailability(id, slot);
    }

    // Member lookup (case-insensitive)
    @GetMapping("/lookup")
    public Member lookupMember(@RequestParam String name) {
        return trainerService.lookupMember(name);
    }
}
