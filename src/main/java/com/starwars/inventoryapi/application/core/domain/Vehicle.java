package com.starwars.inventoryapi.application.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

  private int vehicleId;
  private String name;
  private String model;
  private String vehicleClass;
  private String manufacturer;
  private String length;
  private String costInCredits;
  private String crew;
  private String passengers;
  private String maxAtmospheringSpeed;
  private String cargoCapacity;
  private String consumables;
  private String url;
  private String created;
  private String edited;
  private List<String> films;
  private List<String> pilots;
  private int numberUnits;

}
