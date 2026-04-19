package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class SeanceFullDataDto {
  private Long id;
  private CinemaShortDataDto shortCinema;
  private MovieShortDataDto shortMovie;
  private OffsetDateTime startDateTime;
}