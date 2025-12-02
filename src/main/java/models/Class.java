package models;

import jakarta.persistence.*;

@Entity
@Table(name="Class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long classId; // domain id for the class session

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_id", nullable = false)
    private Dashboard dashboard;

    public Class(){}

    public Class(Long classId) {
        this.classId = classId;
    }

    public Long getId() {
        return id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
