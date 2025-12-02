package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Class")
public class Class {

    @Id
    private Long memberId; // id of member

    private Long classId; // id of group training session


    public Class(){}

    public Class(Long memberId, Long classId) {
        this.memberId = memberId;
        this.classId = classId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
