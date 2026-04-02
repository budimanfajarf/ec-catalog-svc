package day.budi.catalog;

public class OrderService {
    private PaymentService paymentService;

    // Constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(String orderId, int amount) {
        System.out.println(String.format("Placing order %s with amount %d.", orderId, amount));
        paymentService.processPayment(orderId, amount);
        System.out.println(String.format("Order %s has been placed successfully.", orderId));
    }
}
