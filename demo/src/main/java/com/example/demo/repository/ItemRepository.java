package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByNameAndCategory(String name, Category category);

    boolean existsByNameAndCategoryAndIdNot(String name, Category category, Long itemId);
}
