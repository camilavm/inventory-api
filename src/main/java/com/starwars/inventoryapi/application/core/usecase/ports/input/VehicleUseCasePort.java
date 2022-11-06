package com.starwars.inventoryapi.application.core.usecase.ports.input;

import com.starwars.inventoryapi.adapters.outbound.dto.VehicleResponseDto;

public interface VehicleUseCasePort {

  VehicleResponseDto findNumberVehicleUnitsByName(final String name);

  void setNumberVehicleUnitsByName(final String name,
                                    final int numberUnits);

  void incrementNumberVehicleUnitsByName(final String name,
                                          final int numberUnits);

  void decrementNumberVehicleUnitsByName(final String name,
                                          final int numberUnits);
}
