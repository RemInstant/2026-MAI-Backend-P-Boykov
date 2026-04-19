package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieShortDataListDto {
  private List<MovieShortDataDto> shortMovies;
}