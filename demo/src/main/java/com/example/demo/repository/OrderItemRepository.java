package com.example.demo.repository;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<List<OrderItem>> findByOrderIsNull();

    List<OrderItem> findByOrderId(Long orderId);

    OrderItem findByItem(Item item);

}
