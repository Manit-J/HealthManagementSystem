package app.repositories;

import models.PTSession;
import models.Member;
import models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PTSessionRepository extends JpaRepository<PTSession, Long> {
    Optional<PTSession> findByMember(Member member);
    Optional<PTSession> findByTrainer(Trainer trainer);
}
