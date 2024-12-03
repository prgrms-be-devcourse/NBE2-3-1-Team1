package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByDeliveryDateAndEmail(LocalDateTime deliveryDate, String email);
}
