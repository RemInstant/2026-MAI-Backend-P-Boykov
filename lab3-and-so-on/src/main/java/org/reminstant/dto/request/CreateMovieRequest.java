package org.reminstant.dto.request;

import lombok.Data;

@Data
public class CreateMovieRequest {
  private String title;
  private Integer duration;
}
