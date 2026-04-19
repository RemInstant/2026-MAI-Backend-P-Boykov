package org.reminstant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CinemaShortDataListDto {
  private List<CinemaShortDataDto> shortCinemaList;
}