package org.reminstant.controller;

import lombok.RequiredArgsConstructor;
import org.reminstant.dto.response.*;
import org.reminstant.mapping.ResponseDtoMapper;
import org.reminstant.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;

  @GetMapping("/movie")
  ResponseEntity<MovieShortDataListDto> getMoviesShortData(
      @RequestParam(required = false) Long cinemaId
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toMovieShortDataListDto(
            movieService.getAllMovies(cinemaId)
        )
    );
  }

  @GetMapping("/movie/full")
  ResponseEntity<MovieFullDataDto> getMovieFullData(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toMovieFullDataDto(
            movieService.getMovieById(id)
        )
    );
  }

  @GetMapping("movie/seance")
  ResponseEntity<SeanceByMovieDto> getSeancesByMovie(
      @RequestParam Long movieId
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toSeanceByMovieDto(
            movieService.getSeancesByMovie(movieId)
        )
    );
  }

  @GetMapping("movie/search")
  ResponseEntity<MovieFullDataListDto> getMoviesByQueryString(
      @RequestParam String queryString
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toMovieFullDataListDto(
            movieService.getMovieByQueryString(queryString)
        )
    );
  }

}
