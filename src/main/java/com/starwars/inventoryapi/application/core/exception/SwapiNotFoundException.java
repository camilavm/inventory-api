package com.starwars.inventoryapi.application.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SwapiNotFoundException extends RuntimeException {

  private static final String MESSAGE = "SWAPI not found any %s with name %s.";

  public SwapiNotFoundException(final String type,
                                final String name) {
    super(MESSAGE.formatted(type, name));
  }
}
