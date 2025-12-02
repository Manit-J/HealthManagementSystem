package app.repositories;

import models.Dashboard;
import models.Member;
import models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Dashboard findByMember(Member member);
    List<Dashboard> findByTrainer(Trainer trainer);
}
