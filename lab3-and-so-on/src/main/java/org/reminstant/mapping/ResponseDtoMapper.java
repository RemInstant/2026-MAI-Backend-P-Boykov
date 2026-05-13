package org.reminstant.mapping;

import org.reminstant.dto.response.*;
import org.reminstant.entity.*;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseDtoMapper {
  private ResponseDtoMapper() {
  }

  public static CinemaShortDataDto toCinemaShortDataDto(Cinema cinema) {
    return new CinemaShortDataDto(
        cinema.getId(),
        cinema.getName(),
        cinema.getAddress()
    );
  }

  public static CinemaFullDataDto toCinemaFullDataDto(Cinema cinema) {
    return new CinemaFullDataDto(
        cinema.getId(),
        cinema.getName(),
        cinema.getAddress(),
        cinema.getLatitude(),
        cinema.getLongitude()
    );
  }

  public static MovieShortDataDto toMovieShortDataDto(Movie movie) {
    return new MovieShortDataDto(
        movie.getId(),
        movie.getTitle()
    );
  }

  public static MovieFullDataDto toMovieFullDataDto(Movie movie) {
    return new MovieFullDataDto(
        movie.getId(),
        movie.getTitle(),
        movie.getDescription(),
        movie.getDuration()
    );
  }

  public static SeanceShortDataDto toSeanceShortDataDto(Seance seance) {
    return new SeanceShortDataDto(
        seance.getId(),
        seance.getStartDateTime().withOffsetSameInstant(ZoneOffset.UTC)
    );
  }

  public static OrderDto toOrderDto(Order order) {
    return new OrderDto(
        order.getId(),
        toSeanceFullDataDto(order.getSeance())
    );
  }

  public static UserInfoDto toUserInfoDto(UserInfo userInfo) {
    return new UserInfoDto(
        userInfo.getId(),
        userInfo.getUsername(),
        userInfo.getFirstName(),
        userInfo.getLastName(),
        userInfo.getPatronymic()
    );
  }

  public static SeanceFullDataDto toSeanceFullDataDto(Seance seance) {
    return new SeanceFullDataDto(
        seance.getId(),
        toCinemaShortDataDto(seance.getCinema()),
        toMovieShortDataDto(seance.getMovie()),
        seance.getStartDateTime()
    );
  }

  public static CinemaShortDataListDto toCinemaShortDataListDto(List<Cinema> cinemaList) {
    return new CinemaShortDataListDto(
        cinemaList.stream()
            .map(ResponseDtoMapper::toCinemaShortDataDto)
            .toList()
    );
  }

  public static MovieShortDataListDto toMovieShortDataListDto(List<Movie> movieList) {
    return new MovieShortDataListDto(
        movieList.stream()
            .map(ResponseDtoMapper::toMovieShortDataDto)
            .toList()
    );
  }

  public static SeanceByMovieDto toSeanceByMovieDto(List<Seance> seances) {
    return new SeanceByMovieDto(
        seances.stream()
            .collect(Collectors.groupingBy(Seance::getCinema))
            .entrySet().stream()
            .map(entry -> new CinemaSeancesDto(
                toCinemaShortDataDto(entry.getKey()),
                entry.getValue().stream().map(ResponseDtoMapper::toSeanceShortDataDto).toList()
            ))
            .toList()
    );
  }

  public static OrderListDto toOrderListDto(List<Order> orders) {
    return new OrderListDto(
        orders.stream()
            .map(ResponseDtoMapper::toOrderDto)
            .toList()
    );
  }

}
