package day.budi.catalog.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import day.budi.catalog.entities.Product;

public record ProductResponse(
        UUID id,
        Integer price,
        String name,
        UUID storeId,
        String storeName,
        LocalDateTime createdAt) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getUuid(),
                product.getPrice(),
                product.getName(),
                product.getStore().getUuid(),
                product.getStore().getName(),
                product.getCreatedAt());
    }
}
