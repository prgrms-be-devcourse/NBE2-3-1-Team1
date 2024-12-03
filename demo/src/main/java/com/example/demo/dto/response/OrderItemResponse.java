package com.example.demo.dto.response;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;

import java.util.List;

public record OrderItemResponse() {

    public record Create(
            Long itemId,
            String itemName,
            int quantity
    ) {
        public static OrderItemResponse.Create from(OrderItem orderItem) {
            return new OrderItemResponse.Create(orderItem.getItem().getId(), orderItem.getItem().getName(), orderItem.getQuantity());
        }
    }

    public record Read(
            Long itemId,
            int quantity,
            int price
    ) {
        public static OrderItemResponse.Read from(OrderItem orderItem) {
            return new OrderItemResponse.Read(orderItem.getItem().getId(), orderItem.getQuantity(), orderItem.getItem().getPrice()*orderItem.getQuantity());
        }
    }

    public record ReadAll(
            List<Read> orderItems,
            int totalPrice
    ) {
        public static OrderItemResponse.ReadAll from(List<OrderItem> orderItems) {
            int totalPrice = orderItems.stream()
                    .mapToInt(orderItem -> orderItem.getItem().getPrice() * orderItem.getQuantity())
                    .sum();

            return new OrderItemResponse.ReadAll(
                    orderItems.stream().map(Read::from).toList(), totalPrice
            );
        }
    }
}
