package com.club.main;
import com.club.models.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

public class MemberRegistration {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("fitness-club-unit");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        System.out.println("=== MEMBER REGISTRATION ===");

        try {
            // Profile Infoormation
            System.out.print("Enter Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Email (nique): ");
            String email = scanner.nextLine();

            System.out.print("Enter Gender : ");
            String gender = scanner.nextLine();

            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();
            LocalDate dob = LocalDate.parse(dobString);

            // Create Member Object
            Member newMember = new Member();
            newMember.setName(name);
            newMember.setEmail(email);
            newMember.setGender(gender);
            newMember.setDateOfBirth(dob);

            // Save to Database 
            em.getTransaction().begin();
            em.persist(newMember);
            em.getTransaction().commit();

            System.out.println("\nSUCCESS: Member registered with ID: " + newMember.getMemberID());

        } catch (jakarta.persistence.RollbackException e) {
            System.out.println("\nERROR: Registration Failed. A member with this email already exists.");
        } catch (Exception e) {
            System.out.println("\nERROR: Invalid input.");
            e.printStackTrace();
        } finally {
            em.close();
            scanner.close();
            emf.close();
        }
    }
}