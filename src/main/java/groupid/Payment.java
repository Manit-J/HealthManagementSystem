package groupId;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    public Payment() {}

    public Payment(Bill bill, double amount) {
        this.bill = bill;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Bill getBill() {
        return bill;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
}

