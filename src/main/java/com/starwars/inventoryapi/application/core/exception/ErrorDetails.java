package com.starwars.inventoryapi.application.core.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

  private String title;
  private int status;
  private String detail;
  private String developerMessage;

}
