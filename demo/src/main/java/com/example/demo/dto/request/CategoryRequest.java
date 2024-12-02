package com.example.demo.dto.request;

public record CategoryRequest(
) {
    public record Create(
            String name
    ) {
    }
}
