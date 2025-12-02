package models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="HealthHistory")
public class HealthHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate timestamp;

    private int height;

    private int weight;

    private int heartRate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public HealthHistory() {}

    public HealthHistory(LocalDate timestamp, Member member, int height, int weight, int heartRate, int bodyFatPercentage){
        this.timestamp = timestamp;
        this.member = member;
        this.height = height;
        this.weight = weight;
        this.heartRate = heartRate;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public Long getHistoryID() {
        return historyID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void printDetails() {
        System.out.println("Log Date: " + timestamp + " | Weight: " + weight + "kg | Heart Rate: " + heartRate);
    }
}