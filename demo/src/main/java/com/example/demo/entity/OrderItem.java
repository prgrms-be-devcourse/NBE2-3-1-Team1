package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    /* 하나의 주문은 여러 주문 아이템을 가질 수 있다.*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /* 하나의 아이템은 여러 주문아이템에 포함될 수 있다.*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantity;

    @Builder
    public OrderItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public static OrderItem toOrderItem(Item item) {
        if (item.getStockQuantity() < 1) {
            throw new IllegalStateException("상품" + item.getName() + "재고 부족");
        }
        return OrderItem.builder()
                .item(item)
                .quantity(1)
                .build();
    }

    public void updateOrder(Order order) {
        this.order = order;
    }

    public void addQuantity(int quantity) {
        if (item.getStockQuantity() <= quantity) {
            throw new IllegalStateException("상품" + item.getName() + "재고 부족");
        }
        this.quantity += quantity;
    }

    public void addQuantity() {
        if (item.getStockQuantity() <= quantity) {
            throw new IllegalStateException("상품 " + item.getName() + "의 재고가 부족합니다.");
        }
        this.quantity++;
    }

}
