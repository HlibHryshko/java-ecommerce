package com.example.java_ecommerce.services.entity;

import com.example.java_ecommerce.models.entities.Order;
import com.example.java_ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderEntityService extends EntityService<Order, UUID> {

    public OrderEntityService(OrderRepository orderRepository) {
        super(orderRepository);
    }
}
