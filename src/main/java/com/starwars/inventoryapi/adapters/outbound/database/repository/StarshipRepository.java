package com.starwars.inventoryapi.adapters.outbound.database.repository;

import com.starwars.inventoryapi.adapters.outbound.database.entities.StarshipEntity;
import com.starwars.inventoryapi.adapters.outbound.mapper.StarshipMapper;
import com.starwars.inventoryapi.application.core.domain.Starship;
import com.starwars.inventoryapi.application.core.usecase.ports.output.StarshipRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class StarshipRepository implements StarshipRepositoryPort {

  private final SpringStarshipRepository springStarshipRepository;

  public StarshipRepository(final SpringStarshipRepository springStarshipRepository) {
    this.springStarshipRepository = springStarshipRepository;
  }

  @Override
  public void saveNewStarship(final StarshipEntity starshipEntity) {
    this.springStarshipRepository.save(starshipEntity);
  }

  @Override
  public Starship findNumberStarshipUnitsByName(final String name) {
    var starship = this.springStarshipRepository.findByName(name);

    if (starship.isPresent()) {
      return StarshipMapper.entityToDomain(starship.get());
    }

    return null;
  }

  @Override
  public void setNumberStarshipUnitsByName(final StarshipEntity starshipEntity) {
    this.springStarshipRepository.saveAndFlush(starshipEntity);
  }

  @Override
  public void incrementNumberStarshipUnitsByName(final StarshipEntity starshipEntity) {
    this.springStarshipRepository.saveAndFlush(starshipEntity);
  }

  @Override
  public void decrementNumberStarshipUnitsByName(final StarshipEntity starshipEntity) {
    this.springStarshipRepository.saveAndFlush(starshipEntity);
  }
}
