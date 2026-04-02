package day.budi.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    // Constructor
    // use autowired to inject the dependency if there any other constructor
    // @Autowired
    public OrderService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // public OrderService(PaymentService paymentService, String dummy) {
    // this.paymentService = paymentService;
    // }

    public void placeOrder(String orderId, int amount) {
        System.out.println(String.format("Placing order %s with amount %d.", orderId, amount));
        paymentService.processPayment(orderId, amount);
        System.out.println(String.format("Order %s has been placed successfully.", orderId));
    }
}
