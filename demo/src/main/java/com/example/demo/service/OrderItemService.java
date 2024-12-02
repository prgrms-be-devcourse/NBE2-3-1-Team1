package com.example.demo.service;

import com.example.demo.dto.request.OrderItemRequest;
import com.example.demo.entity.Item;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Transactional
    public OrderItem createOrderItem(OrderItemRequest.Create dto, Item item) {
        OrderItem orderItem = orderItemRepository.findByItem(item);

        if (orderItem == null) {
            return orderItemRepository.save(OrderItem.toOrderItem(item));
        } else {
            orderItem.addQuantity();
        }

        return orderItem;
    }

    @Transactional(readOnly = true)
    public List<OrderItem> getOrderItemsWithoutOrder() {
        return orderItemRepository.findByOrderIsNull()
                .orElseThrow(() -> new EntityNotFoundException("장바구니가 존재하지 않습니다."));
    }

    @Transactional(readOnly = true)
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}
