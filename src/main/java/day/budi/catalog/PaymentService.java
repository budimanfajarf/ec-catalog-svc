package day.budi.catalog;

public interface PaymentService {
    void processPayment(String orderId, int amount);
}
