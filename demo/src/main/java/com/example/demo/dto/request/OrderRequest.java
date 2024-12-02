package com.example.demo.dto.request;

public record OrderRequest() {

    public record Create(
            String email,
            String address,
            String zipCode
    ) {

    }
}
