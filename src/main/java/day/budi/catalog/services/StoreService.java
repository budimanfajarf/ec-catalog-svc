package day.budi.catalog.services;

import org.springframework.stereotype.Service;

import day.budi.catalog.entities.Product;
import day.budi.catalog.entities.Store;
import day.budi.catalog.repositories.StoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityStates() {
        var store = Store.builder()
                .name("Budi's Store")
                .build();

        if (entityManager.contains(store)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }

        storeRepository.save(store);

        if (entityManager.contains(store)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }
    }

    @Transactional
    public void showRelatedEntities() {
        var store = Store.builder()
                .name("Budi's Store")
                .build();

        var product1 = Product.builder()
                .name("Product 1")
                .price(10000)
                .build();

        var product2 = Product.builder()
                .name("Product 2")
                .price(20000)
                .build();

        store.addProduct(product1);
        store.addProduct(product2);

        storeRepository.save(store);

        var theStore = storeRepository.findById(6L).orElseThrow();
        for (Product product : theStore.getProducts()) {
            System.out.println("Product Name: " + product.getName());
        }
    }

    @Transactional
    public void deleteRelatedEntities() {
        var store = storeRepository.findById(30L).orElseThrow();
        var firstProduct = store.getProducts().getFirst();
        store.removeProduct(firstProduct);
        storeRepository.save(store);
    }
}
