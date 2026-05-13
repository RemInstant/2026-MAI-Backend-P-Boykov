package org.reminstant.service;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.reminstant.entity.Cinema;
import org.reminstant.entity.Movie;
import org.reminstant.entity.Seance;
import org.reminstant.exception.BusinessException;
import org.reminstant.repository.CinemaRepository;
import org.reminstant.repository.MovieRepository;
import org.reminstant.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

  private final CinemaRepository cinemaRepository;
  private final MovieRepository movieRepository;
  private final SeanceRepository seanceRepository;

  public List<Movie> getAllMovies(@Nullable Long cinemaId) {
    if (cinemaId == null) {
      return movieRepository.findAll();
    }

    return seanceRepository.getAllByCinemaId(cinemaId).stream()
        .map(Seance::getMovie)
        .distinct()
        .toList();
  }

  public Movie getMovieById(long id) {
    return movieRepository.findById(id)
        .orElseThrow(() -> new BusinessException("movie not found"));
  }

  public List<Movie> getMovieByQueryString(String queryString) {
    return movieRepository
        .findAllByTitleContainingOrDescriptionContaining(queryString, queryString);
  }

  public List<Seance> getSeancesByMovie(long movieId) {
    return seanceRepository.getAllByMovieId(movieId);
  }

  public Movie createMovie(String title, String description, Integer duration) {
    return movieRepository.save(new Movie(
        null,
        title,
        description,
        duration
    ));
  }

  public Seance createSeance(long cinemaId, long movieId, OffsetDateTime startDateTime) {
    Cinema cinema = cinemaRepository.findById(cinemaId)
        .orElseThrow(() -> new BusinessException("cinema not found"));
    Movie movie = movieRepository.findById(movieId)
        .orElseThrow(() -> new BusinessException("movie not found"));

    return seanceRepository.save(new Seance(
        null,
        cinema,
        movie,
        startDateTime
    ));
  }

}
