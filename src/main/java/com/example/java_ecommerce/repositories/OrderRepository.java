package com.example.java_ecommerce.repositories;

import com.example.java_ecommerce.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
