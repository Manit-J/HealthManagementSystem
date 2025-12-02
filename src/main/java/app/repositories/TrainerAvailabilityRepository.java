package app.repositories;

import models.TrainerAvailability;
import models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrainerAvailabilityRepository extends JpaRepository<TrainerAvailability, Long> {
    List<TrainerAvailability> findByTrainer(Trainer trainer);
}
