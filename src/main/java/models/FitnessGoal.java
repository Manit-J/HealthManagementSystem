package models;

import jakarta.persistence.*;
import models.Member;

@Entity
@Table(name = "FitnessGoal")
public class FitnessGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // surrogate primary key

    private String fitnessGoal;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public FitnessGoal() {}

    public FitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    // getters and setters
    public Long getId() { return id; }

    public String getFitnessGoal() { return fitnessGoal; }
    public void setFitnessGoal(String fitnessGoal) { this.fitnessGoal = fitnessGoal; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}
