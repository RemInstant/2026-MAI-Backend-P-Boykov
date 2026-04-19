package org.reminstant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie {
  @Id
  private Long id;

  private String title;

  private String description;

  private Integer duration;

}