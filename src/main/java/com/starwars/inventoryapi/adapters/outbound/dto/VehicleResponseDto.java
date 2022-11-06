package com.starwars.inventoryapi.adapters.outbound.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class VehicleResponseDto {

  private String name;
  private String model;
  @JsonProperty("vehicle_class")
  private String vehicleClass;
  private String manufacturer;
  @JsonProperty("cost_in_credits")
  private String costInCredits;
  private String length;
  private String crew;
  private String passengers;
  @JsonProperty("max_atmosphering_speed")
  private String maxAtmospheringSpeed;
  @JsonProperty("cargo_capacity")
  private String cargoCapacity;
  private String consumables;
  private String url;
  private String created;
  private String edited;
  private List<String> films;
  private List<String> pilots;
  @JsonProperty("number_units")
  private int numberUnits;

}
