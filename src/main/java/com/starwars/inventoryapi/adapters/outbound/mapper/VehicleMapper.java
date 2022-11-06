package com.starwars.inventoryapi.adapters.outbound.mapper;

import com.starwars.inventoryapi.adapters.outbound.database.entities.VehicleEntity;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleResponseDto;
import com.starwars.inventoryapi.application.core.domain.Vehicle;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleMapper {

  public Vehicle entityToDomain(VehicleEntity vehicleEntity) {
    return Vehicle.builder()
        .vehicleId(vehicleEntity.getVehicleId())
        .name(vehicleEntity.getName())
        .model(vehicleEntity.getModel())
        .numberUnits(vehicleEntity.getNumberUnits())
        .build();
  }

  public VehicleEntity domainToEntity(Vehicle vehicle) {
    return VehicleEntity.builder()
        .vehicleId(vehicle.getVehicleId())
        .name(vehicle.getName())
        .model(vehicle.getModel())
        .numberUnits(vehicle.getNumberUnits())
        .build();
  }

  public Vehicle responseDtoToDomain(final VehicleResponseDto vehicleResponseDto) {
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

  public VehicleResponseDto domainToResponseDto(final Vehicle vehicle) {
    return VehicleResponseDto.builder()
        .name(vehicle.getName())
        .model(vehicle.getModel())
        .vehicleClass(vehicle.getVehicleClass())
        .manufacturer(vehicle.getManufacturer())
        .costInCredits(vehicle.getCostInCredits())
        .length(vehicle.getLength())
        .crew(vehicle.getCrew())
        .passengers(vehicle.getPassengers())
        .maxAtmospheringSpeed(vehicle.getMaxAtmospheringSpeed())
        .cargoCapacity(vehicle.getCargoCapacity())
        .consumables(vehicle.getConsumables())
        .films(vehicle.getFilms())
        .pilots(vehicle.getPilots())
        .url(vehicle.getUrl())
        .created(vehicle.getCreated())
        .edited(vehicle.getEdited())
        .numberUnits(vehicle.getNumberUnits())
        .build();
  }
}
