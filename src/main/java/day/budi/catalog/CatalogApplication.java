package day.budi.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CatalogApplication.class, args);

		// // https://youtu.be/gJrjgg1KVL4?si=bwUFK2pv0wRp8WkL
		// // it's an example of a Open/Closed Principle
		// // OrderService orderService = new OrderService(new StripeService());
		// OrderService orderService = new OrderService(new PaypalService());
		// orderService.placeOrder("ORDER123", 100000);

		// Spring IoC Container will manage the dependencies injection for us
		var orderService = context.getBean(OrderService.class);
		orderService.placeOrder("ORDER123", 100000);
	}

}
