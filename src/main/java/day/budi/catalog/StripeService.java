package day.budi.catalog;

public class StripeService implements PaymentService {
    @Override
    public void processPayment(String orderId, int amount) {
        // Simulate processing payment with Stripe
        System.out.println("Connecting to Stripe API...");
        System.out.println(String.format("Processing payment for order %s with amount %d.", orderId, amount));
    }
}
