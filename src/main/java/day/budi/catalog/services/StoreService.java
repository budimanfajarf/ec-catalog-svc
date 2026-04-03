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
        var store = storeRepository.findById(6L).orElseThrow();
        for (Product product : store.getProducts()) {
            System.out.println("Product Name: " + product.getName());
        }
    }
}
