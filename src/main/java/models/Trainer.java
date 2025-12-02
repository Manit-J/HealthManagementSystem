package models;

import jakarta.persistence.*;

@Entity
@Table(name="Trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    private String name;

    private String email;

    public Trainer() {}
    public Trainer(Long trainerId, String name, String email) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
    }


    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

