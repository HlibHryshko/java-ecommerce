package com.example.java_ecommerce.controllers;

import com.example.java_ecommerce.models.entities.Product;
import com.example.java_ecommerce.services.entity.ProductEntityService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
public class ProductController {
    private final ProductEntityService productEntityService;

    public ProductController(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @GetMapping("/api/v1/products")
    @ResponseStatus(HttpStatus.OK)
    public Set<Product> getAllProducts() {
        return new HashSet<>(productEntityService.findAll(PageRequest.of(0, 10)).getContent());
    }

    @GetMapping("/api/v1/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable String id) {
        return productEntityService.findById(UUID.fromString(id));
    }

    @PostMapping("/api/v1/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productEntityService.save(product);
    }

    @DeleteMapping("/api/v1/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable String id) {
        productEntityService.deleteById(UUID.fromString(id));
    }
}
