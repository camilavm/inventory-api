package com.starwars.inventoryapi.application.core.usecase.ports.output;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleByNameResponseDto;

public interface SwapiPort {
  StarshipByNameResponseDto findStarshipByName(final String starshipName);

  VehicleByNameResponseDto findVehicleByName(final String vehicleName);
}
