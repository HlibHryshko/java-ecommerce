package com.example.java_ecommerce.repositories;

import com.example.java_ecommerce.models.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {
}
