package com.starwars.inventoryapi.adapters.inbound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitsRequestDto {

  @JsonProperty("number_units")
  private int numberUnits;

}
