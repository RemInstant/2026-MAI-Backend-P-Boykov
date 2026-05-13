package org.reminstant.controller;

import lombok.RequiredArgsConstructor;
import org.reminstant.dto.response.*;
import org.reminstant.mapping.ResponseDtoMapper;
import org.reminstant.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/orders")
  ResponseEntity<OrderListDto> getUserOrders(
      @RequestParam(required = false) Long userId
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toOrderListDto(
            orderService.getUserOrders(userId)
        )
    );
  }

  @PostMapping("/order")
  ResponseEntity<OrderDto> createOrder(
      @RequestParam Long seanceId,
      @RequestParam Long userId
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toOrderDto(
            orderService.createOrder(userId, seanceId)
        )
    );
  }
}
