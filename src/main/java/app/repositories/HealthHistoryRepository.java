package app.repositories;

import models.HealthHistory;
import models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HealthHistoryRepository extends JpaRepository<HealthHistory, Long> {
    List<HealthHistory> findByMember(Member member);
}
