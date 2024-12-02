package com.example.demo.dto.request;

public record ItemRequest() {

    public record Create(
        String name,
        int price,
        Long categoryId
    ) {}
}
