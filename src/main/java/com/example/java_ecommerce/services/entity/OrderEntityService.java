package com.example.java_ecommerce.services.entity;

import com.example.java_ecommerce.models.entities.Order;
import com.example.java_ecommerce.models.entities.OrderProduct;
import com.example.java_ecommerce.models.entities.Product;
import com.example.java_ecommerce.repositories.OrderProductRepository;
import com.example.java_ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderEntityService extends EntityService<Order, UUID> {
    private final ProductEntityService productEntityService;

    private final OrderProductRepository orderProductRepository;

    public OrderEntityService(OrderRepository orderRepository, ProductEntityService productEntityService, OrderProductRepository orderProductRepository) {
        super(orderRepository);
        this.productEntityService = productEntityService;
        this.orderProductRepository = orderProductRepository;
    }

    @Transactional
    public UUID addProductToOrder(UUID orderId, UUID productId, int quantity) {
        Order order = findById(orderId);
        Product product = productEntityService.findById(productId);

        OrderProduct orderProduct = new OrderProduct(order, product, quantity);

        orderProductRepository.save(orderProduct);

        return order.getId();
    }
}
