package org.reminstant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "seance")
@Getter
@Setter
public class Seance {
  @Id
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cinema_id", nullable = false)
  private Cinema cinema;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  private OffsetDateTime startDateTime;

  @OneToMany(mappedBy = "seance")
  private Set<Order> orders = new LinkedHashSet<>();

}