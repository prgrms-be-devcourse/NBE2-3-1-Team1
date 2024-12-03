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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Order order = orderService.createOrder(dto);
        List<OrderItem> resultOrderItems =
                orderItemService.updateOrderItemsByOrder(orderItemService.getAllByOrder(order), orderItemService.getAllByOrderIsNull(), order);

        return ResponseEntity.ok().body(
                OrderResponse.Create.from(order, resultOrderItems)
        );
    }

}
