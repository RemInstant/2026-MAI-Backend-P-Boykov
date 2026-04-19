package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
  private Long id;
  private SeanceFullDataDto shortSeance;
}