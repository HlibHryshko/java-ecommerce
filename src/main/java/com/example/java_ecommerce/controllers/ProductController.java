package com.example.java_ecommerce.controllers;

import com.example.java_ecommerce.models.dtos.ProductDTO;
import com.example.java_ecommerce.services.entity.ProductEntityService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final ProductEntityService productEntityService;

    public ProductController(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @GetMapping("/api/v1/products")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProductDTO.ProductShortRecord> getAllProducts() {
        return productEntityService.findAll(PageRequest.of(0, 10)).getContent().stream().map(ProductDTO::productToProductShortRecord).collect(Collectors.toSet());
    }

    @GetMapping("/api/v1/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO.ProductRecord getProductById(@PathVariable String id) {
        return ProductDTO.productToProductRecord(productEntityService.findById(UUID.fromString(id)));
    }

    @PostMapping("/api/v1/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO.ProductIdRecord createProduct(@RequestBody ProductDTO.ProductCreateRecord productCreateRecord) {
        return new ProductDTO.ProductIdRecord(
                productEntityService.save(ProductDTO.productCreateRecordToProduct(productCreateRecord)).getId()
        );
    }

    @DeleteMapping("/api/v1/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable String id) {
        productEntityService.deleteById(UUID.fromString(id));
    }
}
