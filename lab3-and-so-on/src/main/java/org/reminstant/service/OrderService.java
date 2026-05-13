package org.reminstant.service;

import lombok.RequiredArgsConstructor;
import org.reminstant.entity.Order;
import org.reminstant.entity.Seance;
import org.reminstant.entity.UserInfo;
import org.reminstant.exception.BusinessException;
import org.reminstant.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final SeanceRepository seanceRepository;
  private final OrderRepository orderRepository;
  private final UserInfoRepository userInfoRepository;

  public List<Order> getUserOrders(Long userId) {
    return orderRepository.getOrdersByUserId(userId);
  }

  public Order createOrder(long userId, long seanceId) {
    UserInfo userInfo = userInfoRepository.findById(userId)
        .orElseThrow(() -> new BusinessException("user not found"));
    Seance seance = seanceRepository.findById(seanceId)
        .orElseThrow(() -> new BusinessException("seance not found"));

    return orderRepository.save(new Order(
        null,
        userInfo,
        seance
    ));
  }

}
