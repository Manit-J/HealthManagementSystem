package app;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.GroupClass;
import models.HealthHistory;
import models.Member;

@Service
public class MemberFunctions {

    @PersistenceContext
    private EntityManager em;

    // User Registration
    @Transactional
    public Member registerMember(String name, String dob, String gender, String email) {
        Member member = new Member(name, LocalDate.parse(dob), gender, email);
        
        em.persist(member);
        
        System.out.println(">> User Registration");
        member.printDetails();
        return member;
    }

    // Profile Management
    @Transactional
    public void updateProfile(Long memberID, String newName, String newEmail) {
        Member member = em.find(Member.class, memberID);
        
        if (member != null) {
            member.setName(newName);
            member.setEmail(newEmail);
            
            em.merge(member); 
            
            System.out.println(">>Profile Management ");
            member.printDetails();
        } else {
            System.out.println(">>  Member not found.");
        }
    }

    // Health History
    @Transactional
    public void addHealthMetric(Long memberID, int height, int weight, int heartRate, double bodyFat) {
        Member member = em.find(Member.class, memberID);
        
        if (member != null) {
            HealthHistory history = new HealthHistory(member, height, weight, heartRate, bodyFat);
            em.persist(history);
            
            member.getHealthHistory().add(history);
            
            System.out.println(">> Health History ");
            history.printDetails();
        }
    }

    // Group Class Registration
    @Transactional
    public void registerForGroupClass(Long memberID, Long classID) {
        Member member = em.find(Member.class, memberID);
        GroupClass groupClass = em.find(GroupClass.class, classID);

        if (member != null && groupClass != null) {
            member.getRegisteredClasses().add(groupClass);
            groupClass.getRegisteredMembers().add(member);

            em.merge(member);

            System.out.println(">> Group Class Registration");
            System.out.println("Member " + member.getName() + " registered for " + groupClass.getClassName());
        } else {
            System.out.println(">> Could not register");
        }
    }
}
