package com.starwars.inventoryapi.adapters.outbound.database.repository;

import com.starwars.inventoryapi.adapters.outbound.database.entities.VehicleEntity;
import com.starwars.inventoryapi.adapters.outbound.mapper.VehicleMapper;
import com.starwars.inventoryapi.application.core.domain.Vehicle;
import com.starwars.inventoryapi.application.core.usecase.ports.output.VehicleRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class VehicleRepository implements VehicleRepositoryPort {

  private final SpringVehicleRepository springVehicleRepository;

  public VehicleRepository(final SpringVehicleRepository springVehicleRepository) {
    this.springVehicleRepository = springVehicleRepository;
  }

  @Override
  public void saveNewVehicle(final VehicleEntity vehicleEntity) {
    this.springVehicleRepository.save(vehicleEntity);
  }

  @Override
  public Vehicle findNumberVehicleUnitsByName(final String name) {
    var vehicle = this.springVehicleRepository.findByName(name);

    if (vehicle.isPresent()) {
      return VehicleMapper.entityToDomain(vehicle.get());
    }

    return null;
  }

  @Override
  public void setNumberVehicleUnitsByName(final VehicleEntity vehicleEntity) {
    this.springVehicleRepository.saveAndFlush(vehicleEntity);
  }

  @Override
  public void incrementNumberVehicleUnitsByName(final VehicleEntity vehicleEntity) {
    this.springVehicleRepository.saveAndFlush(vehicleEntity);
  }

  @Override
  public void decrementNumberVehicleUnitsByName(final VehicleEntity vehicleEntity) {
    this.springVehicleRepository.saveAndFlush(vehicleEntity);
  }
}
