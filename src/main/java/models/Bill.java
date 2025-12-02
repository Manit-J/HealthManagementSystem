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
    private Long adminId;

    public Bill(){}

    public Bill(String serviceType, String invoice, double amountDue, String paymentMethod, String paymentStatus, Long adminId) {
        this.serviceType = serviceType;
        this.invoice = invoice;
        this.amountDue = amountDue;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.adminId = adminId;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
