package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByDeliveryDateAndEmail(LocalDateTime deliveryDate, String email);

    List<Order> email(String email);
}
