package org.reminstant.service;

import lombok.RequiredArgsConstructor;
import org.reminstant.entity.Cinema;
import org.reminstant.exception.BusinessException;
import org.reminstant.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {

  private final CinemaRepository cinemaRepository;

  public List<Cinema> getAllCinema() {
    return cinemaRepository.findAll();
  }

  public Cinema getCinemaById(long id) {
    return cinemaRepository.findById(id)
        .orElseThrow(() -> new BusinessException("cinema not found"));
  }

  public Cinema createCinema(String name, String title, BigDecimal latitude, BigDecimal longitude) {
    return cinemaRepository.save(new Cinema(
        null,
        name,
        title,
        latitude,
        longitude
    ));
  }

}
