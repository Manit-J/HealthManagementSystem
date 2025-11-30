package groupId;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/billing")
public class BillingController {

    private final BillingService billing;

    public BillingController(BillingService billing) {
        this.billing = billing;
    }

    // Create bill for a member
    @PostMapping("/create/{memberId}")
    public Bill createBill(@PathVariable Long memberId) {
        return billing.createBill(memberId);
    }

    // Add line item
    @PostMapping("/{billId}/item")
    public Bill addLineItem(@PathVariable Long billId,
                            @RequestBody BillLineItem item) {
        return billing.addLineItem(billId, item);
    }

    // Record payment
    @PostMapping("/{billId}/pay")
    public Bill recordPayment(@PathVariable Long billId,
                              @RequestParam double amount) {
        return billing.recordPayment(billId, amount);
    }
}
