package com.example.demo.dto.response;

import com.example.demo.entity.Item;
import com.example.demo.entity.OrderItem;

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
}
