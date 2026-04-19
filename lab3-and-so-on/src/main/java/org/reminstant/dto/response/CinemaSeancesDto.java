package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CinemaSeancesDto {
  private CinemaShortDataDto shortCinema;
  private List<SeanceShortDataDto> shortSeances;
}