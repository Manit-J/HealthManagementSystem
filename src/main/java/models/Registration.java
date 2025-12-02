package models;

import jakarta.persistence.*;

@Entity
@Table(name="Registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private GroupClass groupClass;

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    public Registration() {}
    public Registration(Member member, GroupClass groupClass, Trainer trainer) {
        this.member = member;
        this.groupClass = groupClass;
        this.trainer = trainer;
    }


    public GroupClass getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(GroupClass groupClass) {
        this.groupClass = groupClass;
    }

    public Member member() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
