package day.budi.catalog;

import org.springframework.stereotype.Service;

@Service("paypal")
public class PaypalService implements PaymentService {
    @Override
    public void processPayment(String orderId, int amount) {
        // Simulate processing payment with PayPal
        System.out.println("Connecting to PayPal API...");
        System.out.println(String.format("Processing payment for order %s with amount %d.", orderId, amount));
    }
}
