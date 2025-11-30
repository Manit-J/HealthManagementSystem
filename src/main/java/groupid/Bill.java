package groupId;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillLineItem> lineItems = new ArrayList<>();

    @Column(nullable = false)
    private double totalAmount = 0;

    @Column(nullable = false)
    private boolean paid = false;

    public Bill() {}

    public Bill(Long memberId) {
        this.memberId = memberId;
    }


    // Billing Logic

    public void addLineItem(BillLineItem item) {
        item.setBill(this);
        lineItems.add(item);
        totalAmount += item.getAmount();
    }

    public void applyPayment(double amount) {
        totalAmount -= amount;
        if (totalAmount <= 0) {
            paid = true;
            totalAmount = 0;
        }
    }



    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<BillLineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }
}
