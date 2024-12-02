package com.example.demo.dto.response;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;

public record ItemResponse() {

    public record Create(
            Long itemId,
            String name,
            int price,
            Long categoryId,
            String categoryName
    ) {
        public static ItemResponse.Create from(Item item) {
            return new ItemResponse.Create(item.getId(), item.getName(), item.getPrice(), item.getCategory().getId(), item.getCategory().getName());
        }
    }
}
