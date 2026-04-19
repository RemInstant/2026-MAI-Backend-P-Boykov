package org.reminstant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
  @Id
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserInfo user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "seance_id")
  private Seance seance;

}