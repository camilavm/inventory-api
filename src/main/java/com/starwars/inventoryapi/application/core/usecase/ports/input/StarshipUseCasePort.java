package com.starwars.inventoryapi.application.core.usecase.ports.input;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipResponseDto;

public interface StarshipUseCasePort {

  StarshipResponseDto findNumberStarshipUnitsByName(final String name);

  void setNumberStarshipUnitsByName(final String name,
                                    final int numberUnits);

  void incrementNumberStarshipUnitsByName(final String name,
                                          final int numberUnits);

  void decrementNumberStarshipUnitsByName(final String name,
                                          final int numberUnits);
}
