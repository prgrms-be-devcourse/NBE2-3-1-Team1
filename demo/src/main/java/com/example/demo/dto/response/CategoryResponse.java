package com.example.demo.dto.response;

import com.example.demo.entity.Category;

public record CategoryResponse() {

    public record Create(
            Long categoryId,
            String name
    ) {
        public static CategoryResponse.Create from(Category category) {
            return new CategoryResponse.Create(category.getId(), category.getName());
        }
    }
}
