package models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FitnessGoal")
public class FitnessGoal {

    @Id
    private Long memberId;

    private String fitnessGoal;


    public FitnessGoal() {
    }

    public FitnessGoal(Long memberId, String goal) {
        this.memberId = memberId;
        this.fitnessGoal = goal;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}