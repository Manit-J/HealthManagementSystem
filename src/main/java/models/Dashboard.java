package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Dasboard")
public class Dashboard {

    @Id
    private Long memberId;
    private Long trainerId;
    private String metrics;
    private String progress; // calculate progress as a percentage for all metrics. e.g. current weight/target weight * 100
    private String attendance;

    public Dashboard() {}

    public Dashboard(Long memberId, Long trainerId, String metrics, String progress, String attendance) {
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.metrics = metrics;
        this.progress = progress;
        this.attendance = attendance;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
