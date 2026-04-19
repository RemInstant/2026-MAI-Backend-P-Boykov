package org.reminstant.controller;

import org.reminstant.dto.response.UserInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/user")
  ResponseEntity<UserInfoDto> getUser(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
        new UserInfoDto(
            id,
            "username",
            "first_name",
            "last_name",
            "patronymic"
        )
    );
  }
}
