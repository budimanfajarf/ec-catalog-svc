package day.budi.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import day.budi.catalog.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    //
}
