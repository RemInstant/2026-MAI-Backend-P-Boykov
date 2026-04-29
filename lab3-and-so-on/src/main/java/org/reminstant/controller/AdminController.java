package org.reminstant.controller;

import org.reminstant.dto.response.CinemaFullDataDto;
import org.reminstant.dto.response.MovieFullDataDto;
import org.reminstant.dto.request.CreateCinemaRequest;
import org.reminstant.dto.request.CreateMovieRequest;
import org.reminstant.dto.request.CreateSeanceRequest;
import org.reminstant.dto.response.SeanceShortDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

  @PostMapping("/admin/cinema")
  ResponseEntity<CinemaFullDataDto> createCinema(
      @RequestBody CreateCinemaRequest request
  ) {
    return ResponseEntity.ok(
        new CinemaFullDataDto(
            1L,
            request.getName(),
            request.getAddress(),
            request.getLatitude(),
            request.getLongitude()
        )
    );
  }

  @PostMapping("/admin/movie")
  ResponseEntity<MovieFullDataDto> createMovie(
      @RequestBody CreateMovieRequest request
  ) {
    return ResponseEntity.ok(
        new MovieFullDataDto(
            1L,
            request.getTitle(),
            request.getDescription(),
            request.getDuration()
        )
    );
  }

  @PostMapping("/admin/seance")
  ResponseEntity<SeanceShortDataDto> createSeance(
      @RequestBody CreateSeanceRequest request
  ) {
    return ResponseEntity.ok(
        new SeanceShortDataDto(
            1L,
            request.getStartDateTime()
        )
    );
  }
}
