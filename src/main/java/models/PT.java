package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PT")
public class PT {

    @Id
    private Long memberId; // id of member
    private Long sessionId; // id of PT session


    public PT(){}

    public PT(Long memberId, Long sessionId) {
        this.memberId = memberId;
        this.sessionId = sessionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
