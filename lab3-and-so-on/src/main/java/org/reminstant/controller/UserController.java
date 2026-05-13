package org.reminstant.controller;

import lombok.RequiredArgsConstructor;
import org.reminstant.dto.response.UserInfoDto;
import org.reminstant.mapping.ResponseDtoMapper;
import org.reminstant.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserInfoService userInfoService;

  @GetMapping("/user")
  ResponseEntity<UserInfoDto> getUser(
      @RequestParam Long id
  ) {
    return ResponseEntity.ok(
        ResponseDtoMapper.toUserInfoDto(
            userInfoService.getUserInfo(id)
        )
    );
  }
}
