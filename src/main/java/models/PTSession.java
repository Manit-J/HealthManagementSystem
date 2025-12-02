package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="PTSession")
public class PTSession {

    @Id
    private Long sessionId;

    private LocalDate timestamp;
    private Long trainerId;
    private Long memberId;

    public PTSession() {}

    public PTSession(Long sessionId, LocalDate timestamp, Long trainerId, Long memberId) {
        this.sessionId = sessionId;
        this.timestamp = timestamp;
        this.trainerId = trainerId;
        this.memberId = memberId;
    }


    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
