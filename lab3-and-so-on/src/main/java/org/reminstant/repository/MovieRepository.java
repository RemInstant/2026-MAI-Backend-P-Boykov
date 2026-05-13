package org.reminstant.repository;

import jakarta.annotation.Nonnull;
import org.reminstant.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
  @Nonnull
  List<Movie> findAll();
  List<Movie> findAllByTitleContainingOrDescriptionContaining(String title, String description);
}
