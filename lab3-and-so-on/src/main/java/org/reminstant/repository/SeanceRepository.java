package org.reminstant.repository;

import org.reminstant.entity.Seance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepository extends CrudRepository<Seance, Long> {
  List<Seance> getAllByCinemaId(long cinemaId);
  List<Seance> getAllByMovieId(long cinemaId);
}
