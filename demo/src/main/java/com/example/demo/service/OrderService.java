package com.example.demo.service;

import com.example.demo.dto.request.OrderRequest;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order createOrder(OrderRequest.Create dto) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deliveryDate;

        if (now.getHour() < 14) {
            deliveryDate = LocalDate.now().atTime(14, 0);
        } else {
            deliveryDate = LocalDate.now().plusDays(1).atTime(14, 0);
        }

        Order order = getOrderByDeliveryDateAndEmail(deliveryDate, dto.email());

        if (order == null) {
            return orderRepository.save(Order.toOrder(dto, now.toLocalTime().isAfter(LocalTime.of(14, 0)) ? OrderStatus.PREPARING : OrderStatus.DELIVERING, deliveryDate));
        }

        return order;
    }

    @Transactional
    public void updateTotalPrice(Order order, List<OrderItem> mergedOrderItems) {
        int totalPrice = mergedOrderItems.stream()
                .mapToInt(orderItem -> orderItem.getQuantity() * orderItem.getItem().getPrice())
                .sum();
        order.updateTotalPrice(totalPrice);
    }


    @Transactional(readOnly = true)
    public Order getOrderByDeliveryDateAndEmail(LocalDateTime deliveryDate, String email) {
        return orderRepository.findByDeliveryDateAndEmail(deliveryDate, email);
    }


}

