package com.example.demo.controller;

import com.example.demo.dto.request.OrderRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Tag(name = "Order API")
public class OrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @Operation(summary = "주문 생성 API")
    @PostMapping
    public ResponseEntity<OrderResponse.Create> createOrder(@RequestBody OrderRequest.Create dto) {
        orderItemService.checkIfOrderItemsExist();

        Order order = orderService.createOrde`r(dto);
        List<OrderItem> mergedOrderItems =
                orderItemService.updateOrderItemsByOrder(
                        orderItemService.getAllByOrder(order), orderItemService.getAllByOrderIsNull(), order);
        orderService.updateTotalPrice(order, mergedOrderItems);

        return ResponseEntity.ok().body(
                OrderResponse.Create.from(order, mergedOrderItems)
        );
    }
    @Operation(summary = "주문 확인 API")
    @GetMapping("/{orderEmail}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable String orderEmail) {
        System.out.println(orderService.getOrderByEmail(orderEmail));
        return ResponseEntity.ok().body(orderService.getOrderByEmail(orderEmail));
    }

    Operation(summary = "주문 취소 API")
    @GetMapping("/{orderId}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable String orderId) {
        System.out.println(orderService.getDeleteById(orderId));
        return ResponseEntity.ok().body(orderService.getOrderByEmail(orderEmail));
    }

}
