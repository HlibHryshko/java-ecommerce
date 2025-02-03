package com.example.java_ecommerce.models.dtos;

import com.example.java_ecommerce.models.entities.Order;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderDTO {
    public static Order orderRecordToOrder(CreateOrderRecord record) {
        Order order = new Order();
        order.getOrderProducts().addAll(record.orderProducts.stream().map(orderRecord -> OrderProductDTO.orderProductRecordToOrderProduct(order, orderRecord)).collect(Collectors.toSet()));
        return order;
    }

    public record OrderIdRecord(
            UUID id
    ) {
    }

    public record CreateOrderRecord(
            Set<OrderProductDTO.OrderProductRecord> orderProducts
    ) {

    }
}
