package com.example.java_ecommerce.controllers;

import com.example.java_ecommerce.models.dtos.OrderDTO;
import com.example.java_ecommerce.services.entity.OrderEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderEntityService orderEntityService;

    public OrderController(OrderEntityService orderEntityService) {
        this.orderEntityService = orderEntityService;
    }

    @PostMapping("/api/v1/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO.OrderIdRecord createOrder(@RequestBody OrderDTO.CreateOrderRecord orderRecord) {
        return new OrderDTO.OrderIdRecord(
                orderEntityService.save(OrderDTO.orderRecordToOrder(orderRecord)).getId()
        );

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
