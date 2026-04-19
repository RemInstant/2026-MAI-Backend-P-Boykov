package org.reminstant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cinema")
@Getter
@Setter
public class Cinema {
  @Id
  private Long id;

  private String name;

  private String address;

  private BigDecimal latitude;

  private BigDecimal longitude;

}