package com.starwars.inventoryapi.adapters.outbound.feign;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.feign.client.SwapiFeignClient;
import com.starwars.inventoryapi.application.core.usecase.ports.output.SwapiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SwapiFeignAdapter implements SwapiPort {

  private final SwapiFeignClient swapiFeignClient;

  @Override
  public StarshipByNameResponseDto findStarshipByName(final String starshipName) {
    return swapiFeignClient.findSwapiStarshipByName(starshipName);
  }

  @Override
  public VehicleByNameResponseDto findVehicleByName(final String vehicleName) {
    return swapiFeignClient.findSwapiVehicleByName(vehicleName);
  }

}
