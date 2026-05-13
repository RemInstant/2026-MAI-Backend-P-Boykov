package org.reminstant.repository;

import jakarta.annotation.Nonnull;
import org.reminstant.entity.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {
  @Nonnull
  List<Cinema> findAll();
}
