package com.example.demo.entity;

import com.example.demo.dto.request.ItemRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "items")
public class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private String imageUrl = "https://i.imgur.com/HKOFQYa.jpeg";

    private int stockQuantity;

    public void addStcok(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        this.stockQuantity = this.stockQuantity - quantity;
        if (this.stockQuantity < 1) {
            throw new IllegalStateException("재고 부족");
        }

    }

    @Builder
    public Item(String name, int price, Category category, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public static Item toItem(ItemRequest.Create dto, Category category) {
        return Item.builder()
                .name(dto.name())
                .price(dto.price())
                .category(category)
                .stockQuantity(dto.stockQuantity())
                .build();
    }

    public void updateItem(String name, int price, Category category, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }
}
