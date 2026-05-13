package org.reminstant.service;

import lombok.RequiredArgsConstructor;
import org.reminstant.entity.UserInfo;
import org.reminstant.exception.BusinessException;
import org.reminstant.repository.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

  private final UserInfoRepository userInfoRepository;

  public UserInfo getUserInfo(long userId) {
    return userInfoRepository.findById(userId)
        .orElseThrow(() -> new BusinessException("user not found"));
  }

}
