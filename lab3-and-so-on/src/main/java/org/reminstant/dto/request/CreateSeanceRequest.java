package org.reminstant.dto.request;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateSeanceRequest {
  private Long cinemaId;
  private Long movieId;
  private OffsetDateTime startDateTime;
}
