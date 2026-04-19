package org.reminstant.controller;

import org.reminstant.dto.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class OrderController {

  @GetMapping("/movies")
  ResponseEntity<OrderListDto> getUserOrders(
      @RequestParam(required = false) Long userId
  ) {
    return ResponseEntity.ok(
        new OrderListDto(
            List.of(
                new OrderDto(
                    1L,
                    new SeanceFullDataDto(
                        1L,
                        new CinemaShortDataDto(
                            1L,
                            "name",
                            "address"
                        ),
                        new MovieShortDataDto(
                            1L,
                            "title"
                        ),
                        OffsetDateTime.now()
                    )
                )
            )
        )
    );
  }

  @PostMapping("/order")
  ResponseEntity<OrderDto> createOrder(
      @RequestParam Long seanceId
  ) {
    return ResponseEntity.ok(
        new OrderDto(
            1L,
            new SeanceFullDataDto(
                1L,
                new CinemaShortDataDto(
                    1L,
                    "name",
                    "address"
                ),
                new MovieShortDataDto(
                    1L,
                    "title"
                ),
                OffsetDateTime.now()
            )
        )
    );
  }
}
