package day.budi.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import day.budi.catalog.entities.Store;

@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);

		// // https://youtu.be/gJrjgg1KVL4?si=bwUFK2pv0wRp8WkL
		// // it's an example of a Open/Closed Principle
		// // OrderService orderService = new OrderService(new StripeService());
		// OrderService orderService = new OrderService(new PaypalService());
		// orderService.placeOrder("ORDER123", 100000);

		// // Spring IoC Container will manage the dependencies injection for us
		// var orderService = context.getBean(OrderService.class);
		// orderService.placeOrder("ORDER123", 100000);

		// var store = Store.builder()
		// .uuid("STORE123")
		// .name("My Store")
		// .address("123 Main St, City, Country")
		// .build();

		// System.out.println("Store Name: " + store.getName());
	}

}
