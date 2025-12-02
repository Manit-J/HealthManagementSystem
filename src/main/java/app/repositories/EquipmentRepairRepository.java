package app.repositories;

import models.EquipmentRepair;
import models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipmentRepairRepository extends JpaRepository<EquipmentRepair, Long> {
    List<EquipmentRepair> findByEquipment(Equipment equipment);
}
