package models;

import jakarta.persistence.Id;

public class Registration {

    @Id
    private Long classId;

    @Id
    private Long memberId;

    @Id
    private Long trainerId;

    public Registration() {}
    public Registration(Long classId, Long memberId, Long trainerId) {
        this.classId = classId;
        this.memberId = memberId;
        this.trainerId = trainerId;
    }


    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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
}
