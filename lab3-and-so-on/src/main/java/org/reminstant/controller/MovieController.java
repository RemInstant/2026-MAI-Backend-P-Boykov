package org.reminstant.controller;

import org.reminstant.dto.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class MovieController {

  @GetMapping("/movie")
  ResponseEntity<MovieShortDataListDto> getMoviesShortData(
      @RequestParam(required = false) Long cinemaId
  ) {
    return ResponseEntity.ok(
        new MovieShortDataListDto(
            List.of(
                new MovieShortDataDto(
                    1L,
                    "title"
                )
            )
        )
    );
  }

  @GetMapping("/movie/full")
  ResponseEntity<MovieFullDataDto> getMovieFullData(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
        new MovieFullDataDto(
            1L,
            "title",
            "description",
            60
        )
    );
  }

  @GetMapping("movie/seance")
  ResponseEntity<SeanceByMovieDto> getSeancesByMovie(
      @RequestParam Long movieId
  ) {
    return ResponseEntity.ok(
        new SeanceByMovieDto(
            List.of(
                new CinemaSeancesDto(
                    new CinemaShortDataDto(
                        1L,
                        "name",
                        "address"
                    ),
                    List.of(
                        new SeanceShortDataDto(
                            1L,
                            OffsetDateTime.now()
                        )
                    )
                )
            )
        )
    );
  }
}
