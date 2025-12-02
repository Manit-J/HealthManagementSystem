package models;

import jakarta.persistence.*;

@Entity
@Table(name="Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private String serviceType;
    private String invoice;
    private double amountDue;
    private String paymentMethod;
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;


    public Bill(){}

    public Bill(String serviceType, String invoice, double amountDue, String paymentMethod, String paymentStatus, Admin admin) {
        this.serviceType = serviceType;
        this.invoice = invoice;
        this.amountDue = amountDue;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.admin = admin;
    }


    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
