package com.starwars.inventoryapi.adapters.outbound.mapper;

import static java.util.Optional.ofNullable;

import com.starwars.inventoryapi.adapters.outbound.dto.VehicleByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleResponseDto;
import com.starwars.inventoryapi.application.core.domain.Vehicle;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleByNameMapper {

  public List<Vehicle> responseDtoToDomain(VehicleByNameResponseDto vehicleByNameResponseDto) {
      return ofNullable(vehicleByNameResponseDto.getResults())
          .orElse(null)
          .stream()
          .map(VehicleByNameMapper::responseDtoToDomain)
          .toList();
  }

  private static Vehicle responseDtoToDomain(final VehicleResponseDto vehicleResponseDto) {
    return Vehicle.builder()
        .name(vehicleResponseDto.getName())
        .model(vehicleResponseDto.getModel())
        .vehicleClass(vehicleResponseDto.getVehicleClass())
        .manufacturer(vehicleResponseDto.getManufacturer())
        .costInCredits(vehicleResponseDto.getCostInCredits())
        .length(vehicleResponseDto.getLength())
        .crew(vehicleResponseDto.getCrew())
        .passengers(vehicleResponseDto.getPassengers())
        .maxAtmospheringSpeed(vehicleResponseDto.getMaxAtmospheringSpeed())
        .cargoCapacity(vehicleResponseDto.getCargoCapacity())
        .consumables(vehicleResponseDto.getConsumables())
        .films(vehicleResponseDto.getFilms())
        .pilots(vehicleResponseDto.getPilots())
        .url(vehicleResponseDto.getUrl())
        .created(vehicleResponseDto.getCreated())
        .edited(vehicleResponseDto.getEdited())
        .numberUnits(vehicleResponseDto.getNumberUnits())
        .build();
  }
}
