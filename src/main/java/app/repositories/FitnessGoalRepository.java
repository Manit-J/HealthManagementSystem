package app.repositories;

import models.FitnessGoal;
import models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {
    List<FitnessGoal> findByMember(Member member);
}
