package com.example.java_ecommerce.models.dtos;

import com.example.java_ecommerce.models.entities.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDTO {
    public static ProductRecord productToProductRecord(Product product) {
        return new ProductRecord(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public static ProductShortRecord productToProductShortRecord(Product product) {
        return new ProductShortRecord(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public static Product productCreateRecordToProduct(ProductCreateRecord productCreateRecord) {
        return new Product(
                productCreateRecord.name(),
                productCreateRecord.price()
        );
    }

    public record ProductIdRecord(
            UUID id
    ) {
    }

    public record ProductCreateRecord(
            String name,
            double price
    ) {
    }

    public record ProductRecord(
            UUID id,
            String name,
            double price,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
    }

    public record ProductShortRecord(
            UUID id,
            String name,
            double price
    ) {
    }
}
