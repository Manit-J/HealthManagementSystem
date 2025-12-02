package app.repositories;

import models.Bill;
import models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByAdmin(Admin admin);
}
