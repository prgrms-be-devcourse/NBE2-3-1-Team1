package com.example.demo.service;

import com.example.demo.dto.request.OrderRequest;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order createOrder(OrderRequest.Create dto, List<OrderItem> orderItems) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deliveryDate;

        if (now.getHour() < 14) {
            deliveryDate = LocalDate.now().atTime(14, 0);
        } else {
            deliveryDate = LocalDate.now().plusDays(1).atTime(14, 0);
        }

        Order order = orderRepository.findByDeliveryDate(deliveryDate);

        if (order == null) {
            order = createNewOrder(dto, orderItems, now.getHour() < 14 ? OrderStatus.DELIVERING : OrderStatus.PREPARING, deliveryDate);
        } else {
            addOrderItemsToOrder(order, orderItems);
        }

        return order;
    }

    private Order createNewOrder(OrderRequest.Create dto, List<OrderItem> orderItems, OrderStatus status, LocalDateTime deliveryDate) {
        Order order = Order.toOrder(dto, status, deliveryDate);
        for (OrderItem orderItem : orderItems) {
            orderItem.createOrder(order);
        }
        return orderRepository.save(order);
    }

    private void addOrderItemsToOrder(Order order, List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            orderItem.createOrder(order);
        }
    }

}
