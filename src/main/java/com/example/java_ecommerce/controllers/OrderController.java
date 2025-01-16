package com.example.java_ecommerce.controllers;

import com.example.java_ecommerce.services.entity.ProductEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final ProductEntityService productEntityService;

    public OrderController(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @PostMapping("/api/v1/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder() {

    }

    @GetMapping("/api/v1/orders")
    @ResponseStatus(HttpStatus.OK)
    public void getAllOrders() {

    }

    @PutMapping("/api/v1/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void submitOrder(@PathVariable String id) {

    }

    @PutMapping("/api/v1/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void completeOrder(@PathVariable String id) {

    }

    @PutMapping("/api/v1/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@PathVariable String id) {

    }


}
