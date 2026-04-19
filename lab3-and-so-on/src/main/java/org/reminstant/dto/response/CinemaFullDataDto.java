package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CinemaFullDataDto {
  private Long id;
  private String name;
  private String address;
  private BigDecimal latitude;
  private BigDecimal longitude;
}