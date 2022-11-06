package com.starwars.inventoryapi.application.core.exception.handler;

import com.starwars.inventoryapi.application.core.exception.ErrorDetails;
import com.starwars.inventoryapi.application.core.exception.InvalidNumberUnitsException;
import com.starwars.inventoryapi.application.core.exception.SwapiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(SwapiNotFoundException.class)
  public ResponseEntity<?> handlerSwapiStarshipNotFoundException(SwapiNotFoundException ex) {
    var details = ErrorDetails.builder()
        .title("Starship not found in Star Wars API")
        .status(HttpStatus.NOT_FOUND.value())
        .detail(ex.getMessage())
        .developerMessage(ex.getClass().getName())
        .build();

    return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidNumberUnitsException.class)
  public ResponseEntity<?> handlerSwapiStarshipNotFoundException(InvalidNumberUnitsException ex) {
    var details = ErrorDetails.builder()
        .title("Invalid number of units")
        .status(HttpStatus.BAD_REQUEST.value())
        .detail(ex.getMessage())
        .developerMessage(ex.getClass().getName())
        .build();

    return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
  }
}
