package com.example.demo.entity;

import com.example.demo.dto.request.OrderRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zipCode;

    /* 주문 발송일*/
    private LocalDateTime deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Builder
    public Order(String email, String address, String zipCode, OrderStatus status, LocalDateTime deliveryDate) {
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }

    public static Order toOrder(OrderRequest.Create dto, OrderStatus status, LocalDateTime deliveryDate) {
        return Order.builder()
                .email(dto.email())
                .address(dto.address())
                .zipCode(dto.zipCode())
                .status(status)
                .deliveryDate(deliveryDate)
                .build();
    }

}
