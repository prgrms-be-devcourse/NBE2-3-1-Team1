package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Transactional
    public OrderItem createOrderItem(Item item) {
        OrderItem orderItem = orderItemRepository.findByItemAndOrderIsNull(item);

        if (orderItem == null) {
            return orderItemRepository.save(OrderItem.toOrderItem(item));
        } else {
            orderItem.addQuantity();
        }

        return orderItem;
    }

    @Transactional
    public List<OrderItem> updateOrderItemsByOrder(List<OrderItem> orderItemsByOrder, List<OrderItem> orderItemsByOrderIsNull, Order order) {

        Map<Long, OrderItem> mergedOrderItems = new HashMap<>();

        for (OrderItem orderItem : orderItemsByOrder) {
            Long key = orderItem.getItem().getId();
            mergedOrderItems.put(key, orderItem);
        }

        for (OrderItem orderItem : orderItemsByOrderIsNull) {
            Long key = orderItem.getItem().getId();
            Item item = orderItem.getItem();
            if (item.getStockQuantity() < orderItem.getQuantity()) {
                throw new IllegalStateException("상품" + item.getName() + "재고가 부족합니다");
            }
            item.removeStock(orderItem.getQuantity());

            if (mergedOrderItems.containsKey(key)) {
                mergedOrderItems.get(key).addQuantity(orderItem.getQuantity());
            } else {
                orderItem.updateOrder(order);
                mergedOrderItems.put(key, orderItem);
            }
        }

        orderItemsByOrder.clear();
        orderItemsByOrder.addAll(mergedOrderItems.values());

        clearOrderItemsAfterOrder();

        return orderItemsByOrder;
    }


    @Transactional(readOnly = true)
    public List<OrderItem> getAllByOrderIsNull() {
        return orderItemRepository.findAllByOrderIsNull();
    }

    @Transactional(readOnly = true)
    public List<OrderItem> getAllByOrder(Order order) {
        return orderItemRepository.findAllByOrder(order);
    }

    @Transactional(readOnly = true)
    public void checkIfOrderItemsExist() {
        if (orderItemRepository.findAllByOrderIsNull().isEmpty()) {
            throw new IllegalStateException("장바구니가 존재하지 않습니다.");
        }
    }

    @Transactional
    public void clearOrderItemsAfterOrder() {
        List<OrderItem> orderItems = getAllByOrderIsNull();
        orderItemRepository.deleteAll(orderItems);
    }
}
