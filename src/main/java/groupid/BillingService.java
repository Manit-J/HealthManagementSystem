package groupId;

import org.springframework.stereotype.Service;

@Service
public class BillingService {

    private final BillRepository billRepo;

    public BillingService(BillRepository billRepo) {
        this.billRepo = billRepo;
    }

    public Bill createBill(Long memberId) {
        return billRepo.save(new Bill(memberId));
    }

    public Bill addLineItem(Long billId, BillLineItem item) {
        Bill bill = billRepo.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        bill.addLineItem(item);
        return billRepo.save(bill);
    }

    public Bill recordPayment(Long billId, double amount) {
        Bill bill = billRepo.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        bill.applyPayment(amount);
        return billRepo.save(bill);
    }
}
