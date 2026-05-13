package org.reminstant.controller;

import lombok.RequiredArgsConstructor;
import org.reminstant.dto.response.CinemaFullDataDto;
import org.reminstant.dto.response.CinemaShortDataListDto;
import org.reminstant.mapping.ResponseDtoMapper;
import org.reminstant.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CinemaController {

  private final CinemaService cinemaService;

  @GetMapping("/cinema")
  ResponseEntity<CinemaShortDataListDto> getAllCinema() {
    return ResponseEntity.ok(
        ResponseDtoMapper.toCinemaShortDataListDto(
            cinemaService.getAllCinema()
        )
    );
  }

  @GetMapping("/cinema/full")
  ResponseEntity<CinemaFullDataDto> getCinemaFullData(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toCinemaFullDataDto(
            cinemaService.getCinemaById(id)
        )
    );
  }
}
