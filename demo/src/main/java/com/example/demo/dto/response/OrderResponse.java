package com.example.demo.dto.response;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse() {

    public record Create(
            Long orderId,
            String email,
            String address,
            String zipCode,
            List<OrderItemResponse.Create> orderItems,
            OrderStatus status,
            LocalDateTime deliveryDate
    ) {
        public static OrderResponse.Create from(Order order, List<OrderItem> orderItems) {
            List<OrderItemResponse.Create> orderItemResponses = orderItems.stream()
                    .map(OrderItemResponse.Create::from).toList();
            return new OrderResponse.Create(order.getId(), order.getEmail(), order.getAddress(), order.getZipCode(), orderItemResponses, order.getStatus(), order.getDeliveryDate());
        }
    }
}
