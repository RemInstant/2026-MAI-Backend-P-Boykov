package org.reminstant.repository;

import org.reminstant.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> getOrdersByUserId(long userId);
}
