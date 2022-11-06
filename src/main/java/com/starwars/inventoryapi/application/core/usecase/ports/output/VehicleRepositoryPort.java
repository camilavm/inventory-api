package com.starwars.inventoryapi.application.core.usecase.ports.output;

import com.starwars.inventoryapi.adapters.outbound.database.entities.VehicleEntity;
import com.starwars.inventoryapi.application.core.domain.Vehicle;

public interface VehicleRepositoryPort {

  public void saveNewVehicle(final VehicleEntity vehicleEntity);

  Vehicle findNumberVehicleUnitsByName(final String name);

  public void setNumberVehicleUnitsByName(final VehicleEntity vehicleEntity);

  void incrementNumberVehicleUnitsByName(final VehicleEntity vehicleEntity);

  void decrementNumberVehicleUnitsByName(final VehicleEntity vehicleEntity);

}
