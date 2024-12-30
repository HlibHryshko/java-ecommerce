package com.example.java_ecommerce.services.entity;

import com.example.java_ecommerce.models.entities.Product;
import com.example.java_ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductEntityService extends EntityService<Product, UUID> {
    public ProductEntityService(ProductRepository repository) {
        super(repository);
    }
}
