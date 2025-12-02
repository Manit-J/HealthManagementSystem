package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {

  @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long memberID;

private String name;

private LocalDate dateOfBirth;

private String gender;

private String email;

@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<HealthHistory> healthHistory = new ArrayList<>();

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
    name = "Registration",
    joinColumns = @JoinColumn(name = "member_id"),
    inverseJoinColumns = @JoinColumn(name = "class_id")
)
private List<GroupClass> registeredClasses = new ArrayList<>();

public Member() {
}

public Member(String name, LocalDate dateOfBirth, String gender, String email) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.email = email;
}

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

public List<HealthHistory> getHealthHistory() {
    return healthHistory;
}

public void setHealthHistory(List<HealthHistory> healthHistory) {
    this.healthHistory = healthHistory;
}

public List<GroupClass> getRegisteredClasses() {
    return registeredClasses;
}

public void setRegisteredClasses(List<GroupClass> registeredClasses) {
    this.registeredClasses = registeredClasses;
}

public void printDetails() {
    System.out.println("Member ID: " + memberID + " | Name: " + name + " | Email: " + email);
}
}