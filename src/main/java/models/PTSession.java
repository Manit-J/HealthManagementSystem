package models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="PTSession")
public class PTSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private LocalDate timestamp;

    @OneToOne
    @JoinColumn(name = "trainer_id", unique = true, nullable = false)
    private Trainer trainer;


    @OneToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;

    public PTSession() {}

    public PTSession(Long sessionId, LocalDate timestamp, Trainer trainer, Member member) {
        this.sessionId = sessionId;
        this.timestamp = timestamp;
        this.trainer = trainer;
        this.member = member;
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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Member member() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
