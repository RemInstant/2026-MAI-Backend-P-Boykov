package org.reminstant.controller;

import lombok.AllArgsConstructor;
import org.reminstant.dto.response.CinemaFullDataDto;
import org.reminstant.dto.response.MovieFullDataDto;
import org.reminstant.dto.request.CreateCinemaRequest;
import org.reminstant.dto.request.CreateMovieRequest;
import org.reminstant.dto.request.CreateSeanceRequest;
import org.reminstant.dto.response.SeanceFullDataDto;
import org.reminstant.mapping.ResponseDtoMapper;
import org.reminstant.service.CinemaService;
import org.reminstant.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AdminController {

  private final CinemaService cinemaService;
  private final MovieService movieService;

  @PostMapping("/admin/cinema")
  ResponseEntity<CinemaFullDataDto> createCinema(
      @RequestBody CreateCinemaRequest request
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toCinemaFullDataDto(
            cinemaService.createCinema(
                request.getName(),
                request.getAddress(),
                request.getLatitude(),
                request.getLongitude()
            )
        )
    );
  }

  @PostMapping("/admin/movie")
  ResponseEntity<MovieFullDataDto> createMovie(
      @RequestBody CreateMovieRequest request
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toMovieFullDataDto(
            movieService.createMovie(
                request.getTitle(),
                request.getDescription(),
                request.getDuration()
            )
        )
    );
  }

  @PostMapping("/admin/seance")
  ResponseEntity<SeanceFullDataDto> createSeance(
      @RequestBody CreateSeanceRequest request
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toSeanceFullDataDto(
            movieService.createSeance(
                request.getCinemaId(),
                request.getMovieId(),
                request.getStartDateTime()
            )
        )
    );
  }
}
