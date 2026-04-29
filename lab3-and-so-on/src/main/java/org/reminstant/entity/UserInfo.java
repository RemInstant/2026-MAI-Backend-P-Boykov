package org.reminstant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserInfo {
  @Id
  private Long id;

  private String username;

  private String passwordHash;

  private String firstName;

  private String lastName;

  private String patronymic;

}
