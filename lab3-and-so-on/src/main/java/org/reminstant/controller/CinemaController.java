package org.reminstant.controller;

import org.reminstant.dto.response.CinemaFullDataDto;
import org.reminstant.dto.response.CinemaShortDataDto;
import org.reminstant.dto.response.CinemaShortDataListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CinemaController {

  @GetMapping("/cinema")
  ResponseEntity<CinemaShortDataListDto> getAllCinema() {
    return ResponseEntity.ok(
        new CinemaShortDataListDto(
            List.of(
                new CinemaShortDataDto(
                    1L,
                    "title",
                    "address"
                )
            )
        )
    );
  }

  @GetMapping("/cinema/full")
  ResponseEntity<CinemaFullDataDto> getCinemaFullData(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
          new CinemaFullDataDto(
          1L,
          "title",
          "address",
          BigDecimal.valueOf(1),
          BigDecimal.valueOf(1)
      )
    );
  }
}
