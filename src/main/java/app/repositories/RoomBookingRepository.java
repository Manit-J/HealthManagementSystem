package app.repositories;

import models.RoomBooking;
import models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long> {
    List<RoomBooking> findByAdmin(Admin admin);
}
