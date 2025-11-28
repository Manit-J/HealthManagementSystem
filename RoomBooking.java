package com.club.main;
import com.club.models.GroupClasses;
import com.club.models.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;

public class RoomBooking {

    /**
     * book a room for a class.
     * * @param em        
     * @param className The name of the class 
     * @param start     Start time
     * @param end       End time
     * @param room      The Room entity object
     */
    public static void bookRoom(EntityManager em, String className, LocalDateTime start, LocalDateTime end, Room room) {
        
        //Check for conflicts in the database
        String hql = "SELECT COUNT(c) FROM GroupClasses c WHERE c.room = :room " +
                     "AND c.startTime < :end AND c.endTime > :start";
        
        TypedQuery<Long> query = em.createQuery(hql, Long.class);
        query.setParameter("room", room);
        query.setParameter("start", start);
        query.setParameter("end", end);
        
        Long conflictCount = query.getSingleResult();

        if (conflictCount == 0) {
            //No Conflict 
            GroupClasses newClass = new GroupClasses(className, start, end, room);
            em.persist(newClass);
            System.out.println("SUCCESS: '" + className + "' booked in " + room.getRoomName());
        } else {
            // Conflict 
            System.out.println("ERROR: Double Booking! " + room.getRoomName() + " is busy during this time.");
        }
    }
}