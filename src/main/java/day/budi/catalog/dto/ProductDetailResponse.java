package day.budi.catalog.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import day.budi.catalog.entities.Product;

public record ProductDetailResponse(
        UUID id,
        Integer price,
        String name,
        UUID storeId,
        String storeName,
        LocalDateTime createdAt,
        String description,
        String storeAddress) {

    public static ProductDetailResponse from(Product product) {
        return new ProductDetailResponse(
                product.getUuid(),
                product.getPrice(),
                product.getName(),
                product.getStore().getUuid(),
                product.getStore().getName(),
                product.getCreatedAt(),
                product.getDescription(),
                product.getStore().getAddress());
    }
}
