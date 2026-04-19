package org.reminstant.controller;

import org.reminstant.dto.response.CinemaFullDataDto;
import org.reminstant.dto.response.MovieFullDataDto;
import org.reminstant.dto.request.CreateCinemaRequest;
import org.reminstant.dto.request.CreateMovieRequest;
import org.reminstant.dto.request.CreateSeanceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

  @PostMapping("/admin/cinema")
  ResponseEntity<CinemaFullDataDto> createCinema(
      @RequestBody CreateCinemaRequest request
  ) {
    return ResponseEntity.ok(null);
  }

  @PostMapping("/admin/movie")
  ResponseEntity<MovieFullDataDto> createMovie(
      @RequestBody CreateMovieRequest request
  ) {
    return ResponseEntity.ok(null);
  }

  @PostMapping("/admin/seance")
  ResponseEntity<CreateSeanceRequest> createSeance(
      @RequestBody CreateSeanceRequest request
  ) {
    return ResponseEntity.ok(null);
  }
}
