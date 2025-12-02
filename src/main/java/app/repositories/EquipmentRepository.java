package app.repositories;

import models.Equipment;
import models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByAdmin(Admin admin);
}
