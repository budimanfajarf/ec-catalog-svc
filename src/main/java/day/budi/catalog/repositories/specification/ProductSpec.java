package day.budi.catalog.repositories.specification;

import org.springframework.data.jpa.domain.Specification;

import day.budi.catalog.entities.Product;

public class ProductSpec {
    public static Specification<Product> hasNameLike(String name) {
        return (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
    }
}
