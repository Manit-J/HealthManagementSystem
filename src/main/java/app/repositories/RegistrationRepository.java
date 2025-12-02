package app.repositories;

import models.Registration;
import models.Member;
import models.GroupClass;
import models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByMember(Member member);
    List<Registration> findByTrainer(Trainer trainer);
    List<Registration> findByGroupClass(GroupClass groupClass);
}
