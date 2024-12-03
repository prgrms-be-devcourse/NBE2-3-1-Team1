package com.example.demo.controller;

import com.example.demo.dto.request.OrderItemRequest;
import com.example.demo.dto.response.OrderItemResponse;
import com.example.demo.entity.OrderItem;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order-items")
@Tag(name = "OrderItem API")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final ItemService itemService;

    @PostMapping
    @Operation(summary = "장바구니 추가 API")
    public ResponseEntity<OrderItemResponse.Create> createOrderItem(@RequestBody OrderItemRequest.Create dto) {
        return ResponseEntity.ok().body(
                OrderItemResponse.Create.from(orderItemService.createOrderItem(dto, itemService.getItemById(dto.itemId()))));
    }

    @GetMapping
    @Operation(summary = "장바구니 전체 조회 API")
    public ResponseEntity<OrderItemResponse.ReadAll> getAllOrderItems() {
        return ResponseEntity.ok().body(
                OrderItemResponse.ReadAll.from(orderItemService.getAllByOrderIsNull())
        );
    }
}
