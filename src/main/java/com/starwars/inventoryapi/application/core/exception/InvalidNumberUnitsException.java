package com.starwars.inventoryapi.application.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNumberUnitsException extends RuntimeException {

  private static final String MESSAGE = "The number of units for %s must to be equals or bigger than 0.";

  public InvalidNumberUnitsException(final String numberUnits) {
    super(MESSAGE.formatted(numberUnits));
    System.err.println(this.getMessage());
  }
}
