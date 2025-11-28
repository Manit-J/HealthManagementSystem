package com.club.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    // 1. PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberID;


    // 2. ATTRIBUTES 
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "body_fat_percentage")
    private Double bodyFatPercentage;

   
    // 3. RELATIONSHIPS

    // Relationship: Member —→ FitnessGoal 
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<FitnessGoal> fitnessGoals = new HashSet<>();

    // Relationship: Member —→ PT sessions 
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PT> ptSessions = new HashSet<>();

    // Relationship: Member —→ GroupClasses 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "group_class_members",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<GroupClasses> attendedClasses = new HashSet<>();


    // 4. CONSTRUCTORS
    public Member() {
    }

    public Member(String name, LocalDate dateOfBirth, String gender, String email, 
                  Double height, Double weight, Integer heartRate, Double bodyFatPercentage) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.heartRate = heartRate;
        this.bodyFatPercentage = bodyFatPercentage;
    }


    // 5. GETTERS AND SETTERS
    public Long getMemberID() {
        return memberID;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(Double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    //  Relationship 

    public Set<FitnessGoal> getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(Set<FitnessGoal> fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    
    // Helper method to add 
    public void addFitnessGoal(FitnessGoal goal) {
        this.fitnessGoals.add(goal);
        goal.setMember(this);
    }

    public Set<PT> getPtSessions() {
        return ptSessions;
    }

    public void setPtSessions(Set<PT> ptSessions) {
        this.ptSessions = ptSessions;
    }

    public Set<GroupClasses> getAttendedClasses() {
        return attendedClasses;
    }

    public void setAttendedClasses(Set<GroupClasses> attendedClasses) {
        this.attendedClasses = attendedClasses;
    }
}