package com.starwars.inventoryapi.application.core.usecase.ports.output;

import com.starwars.inventoryapi.adapters.outbound.database.entities.StarshipEntity;
import com.starwars.inventoryapi.application.core.domain.Starship;

public interface StarshipRepositoryPort {

  public void saveNewStarship(final StarshipEntity starshipEntity);

  Starship findNumberStarshipUnitsByName(final String name);

  public void setNumberStarshipUnitsByName(final StarshipEntity starshipEntity);

  void incrementNumberStarshipUnitsByName(final StarshipEntity starshipEntity);

  void decrementNumberStarshipUnitsByName(final StarshipEntity starshipEntity);

}
