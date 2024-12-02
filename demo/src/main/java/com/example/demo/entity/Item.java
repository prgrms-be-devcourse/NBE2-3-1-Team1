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

    @Builder
    public Item(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Item toItem(ItemRequest.Create dto, Category category) {
        return Item.builder()
                .name(dto.name())
                .price(dto.price())
                .category(category)
                .build();
    }
}
