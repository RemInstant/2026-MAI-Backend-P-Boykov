package org.reminstant.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateCinemaRequest {
  private String name;
  private String address;
  private BigDecimal latitude;
  private BigDecimal longitude;
}
