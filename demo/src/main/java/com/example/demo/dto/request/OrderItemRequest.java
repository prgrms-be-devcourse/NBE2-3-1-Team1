package com.example.demo.dto.request;

public record OrderItemRequest() {

    public record Create(
        Long itemId
    ) {}
}
