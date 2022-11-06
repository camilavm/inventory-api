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
public class Starship {

  private int starshipId;
  private String name;
  private String model;
  private String starshipClass;
  private String manufacturer;
  private String costInCredits;
  private String length;
  private String crew;
  private String passengers;
  private String maxAtmospheringSpeed;
  private String hyperdriveRating;
  private String MGLT;
  private String cargoCapacity;
  private String consumables;
  private String url;
  private String created;
  private String edited;
  private List<String> films;
  private List<String> pilots;
  private int numberUnits;

}
