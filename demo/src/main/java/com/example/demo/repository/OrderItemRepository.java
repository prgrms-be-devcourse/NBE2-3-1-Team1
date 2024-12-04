package com.example.demo.repository;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrderIsNull();

    List<OrderItem> findAllByOrder(Order order);

    OrderItem findByItemAndOrderIsNull(Item item);

}
