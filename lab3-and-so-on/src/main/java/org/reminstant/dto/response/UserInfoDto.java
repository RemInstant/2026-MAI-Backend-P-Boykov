package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
  private Long id;
  private String username;
  private String firstName;
  private String lastName;
  private String patronymic;
}
