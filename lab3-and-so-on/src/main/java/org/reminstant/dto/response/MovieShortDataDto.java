package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieShortDataDto {
  private Long id;
  private String title;
}