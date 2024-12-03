package com.example.demo.controller;

import com.example.demo.dto.request.OrderRequest;
import com.example.demo.dto.response.OrderItemResponse;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// restful 개발 컨트롤러에 사용 html이 아닌 json 형식으로 반환
@RestController
// 한꺼번에 매핑 가넝!
@RequestMapping("/api/ah/orders")
// swagger 에서 볼수있는거같다, test할때도 볼수있는 듯
@Tag(name = "AH Order API")
public class OrderCon {
  private final OrderItemService orderItemService;

  public OrderCon(OrderItemService orderItemService) {
    this.orderItemService = orderItemService;
  }

  // 오버라이딩 처럼 할수있는 듯?
  @GetMapping
  public ResponseEntity createOrder() {
    return ResponseEntity.ok("OK");
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderItemResponse.ReadAll> getOrder(@PathVariable String orderId) {
    return ResponseEntity.ok().body(
            OrderItemResponse.ReadAll.from(orderItemService.getAllByOrderIsNull())
    );
  }


}
