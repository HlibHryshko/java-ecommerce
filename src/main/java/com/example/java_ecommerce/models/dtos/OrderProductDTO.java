package com.example.java_ecommerce.models.dtos;

import com.example.java_ecommerce.models.entities.Order;
import com.example.java_ecommerce.models.entities.OrderProduct;
import com.example.java_ecommerce.models.entities.Product;

public class OrderProductDTO {

    public static OrderProduct orderProductRecordToOrderProduct(Order order, OrderProductRecord orderProductRecord) {
        return new OrderProduct(
                order,
                new Product(
                        orderProductRecord.name,
                        orderProductRecord.price
                ),
                orderProductRecord.quantity
        );
    }

    public record OrderProductRecord(
            String name,
            double price,
            int quantity,
            double totalPrice
    ) {
    }
}
