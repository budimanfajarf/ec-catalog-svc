package day.budi.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		// SpringApplication.run(CatalogApplication.class, args);

		// https://youtu.be/gJrjgg1KVL4?si=bwUFK2pv0wRp8WkL
		// it's an example of a Open/Closed Principle
		// OrderService orderService = new OrderService(new StripeService());
		OrderService orderService = new OrderService(new PaypalService());
		orderService.placeOrder("ORDER123", 100000);
	}

}
