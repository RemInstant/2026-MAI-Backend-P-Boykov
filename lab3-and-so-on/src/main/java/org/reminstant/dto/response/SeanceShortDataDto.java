package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class SeanceShortDataDto {
  private Long id;
  private OffsetDateTime startDateTime;
}