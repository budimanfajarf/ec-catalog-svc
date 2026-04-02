package day.budi.catalog;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("stripe")
// @Primary
public class StripeService implements PaymentService {
    @Override
    public void processPayment(String orderId, int amount) {
        // Simulate processing payment with Stripe
        System.out.println("Connecting to Stripe API...");
        System.out.println(String.format("Processing payment for order %s with amount %d.", orderId, amount));
    }
}
