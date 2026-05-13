package org.reminstant.controller;

import org.reminstant.dto.response.ErrorDto;
import org.reminstant.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorDto> handleBusinessException(Exception ex) {
    return ResponseEntity.badRequest().body(
        new ErrorDto(ex.getMessage())
    );
  }

}
