package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieFullDataDto {
  private Long id;
  private String title;
  private String description;
  private Integer duration;
}