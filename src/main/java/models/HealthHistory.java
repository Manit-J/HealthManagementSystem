package models;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class HealthHistory {

    @Id
    private LocalDate timestamp;

    @Id
    private Long memberId;

    private int height;
    private int weight;
    private int heartRate;
    private int bodyFatPercentage;

    public HealthHistory() {}

    public HealthHistory(LocalDate timestamp, Long memberId, int height, int weight, int heartRate, int bodyFatPercentage){
        this.timestamp = timestamp;
        this.memberId = memberId;
        this.height = height;
        this.weight = weight;
        this.heartRate = heartRate;
        this.bodyFatPercentage = bodyFatPercentage;
    }


    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public int getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(int bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }
}
