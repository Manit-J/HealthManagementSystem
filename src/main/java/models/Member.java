package models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private LocalDate dateOfBirth;

    private String gender;

    private String email;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FitnessGoal> fitnessGoals = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dashboard_id", unique = true)
    private Dashboard dashboard;

    @OneToMany(mappedBy = "member")
    private List<HealthHistory> healthHistory = new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private PTSession ptSession;

    @ManyToMany
    @JoinTable(
            name = "member_groupclass",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<GroupClass> classes = new HashSet<>();

    @OneToMany(mappedBy = "member")
    private Set<Registration> registrations = new HashSet<>();


    public Member() {
    }

    public Member(String name, LocalDate dateOfBirth, String gender, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
    }


    public Long getMemberID() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<FitnessGoal> getFitnessGoals() { return fitnessGoals; }

    public void addFitnessGoal(FitnessGoal goal) {
        fitnessGoals.add(goal);
        goal.setMember(this);
    }
}