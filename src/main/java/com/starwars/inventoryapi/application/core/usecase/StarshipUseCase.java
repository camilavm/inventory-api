package com.starwars.inventoryapi.application.core.usecase;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipResponseDto;
import com.starwars.inventoryapi.adapters.outbound.mapper.StarshipByNameMapper;
import com.starwars.inventoryapi.adapters.outbound.mapper.StarshipMapper;
import com.starwars.inventoryapi.application.core.domain.Starship;
import com.starwars.inventoryapi.application.core.exception.InvalidNumberUnitsException;
import com.starwars.inventoryapi.application.core.exception.SwapiNotFoundException;
import com.starwars.inventoryapi.application.core.usecase.ports.input.StarshipUseCasePort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.StarshipRepositoryPort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.SwapiPort;
import org.springframework.data.crossstore.ChangeSetPersister;

public class StarshipUseCase implements StarshipUseCasePort {

  private static final String STARSHIP_CONST = "starship";

  private final StarshipRepositoryPort starshipRepositoryPort;
  private final SwapiPort swapiPort;

  public StarshipUseCase(final StarshipRepositoryPort starshipRepositoryPort,
                         final SwapiPort swapiPort) {
    this.starshipRepositoryPort = starshipRepositoryPort;
    this.swapiPort = swapiPort;
  }

  @Override
  public StarshipResponseDto findNumberStarshipUnitsByName(final String name) {
    try {
      var swapiStarshipByNameResponseDto = swapiPort.findStarshipByName(name);
      if (swapiStarshipByNameResponseDto == null || swapiStarshipByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var starship = this.starshipRepositoryPort.findNumberStarshipUnitsByName(name);
      var starshipByName = StarshipByNameMapper.responseDtoToDomain(swapiStarshipByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (starship == null) {
        starshipByName.setStarshipId(getStarshipId(starshipByName));
        this.starshipRepositoryPort.saveNewStarship(StarshipMapper.domainToEntity(starshipByName));
      } else {
        starshipByName.setNumberUnits(starship.getNumberUnits());
      }

      return StarshipMapper.domainToResponseDto(starshipByName);
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(STARSHIP_CONST, name);
    }
  }

  @Override
  public void setNumberStarshipUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(STARSHIP_CONST);
      }

      var swapiStarshipByNameResponseDto = swapiPort.findStarshipByName(name);
      if (swapiStarshipByNameResponseDto == null || swapiStarshipByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var starshipByName = StarshipByNameMapper.responseDtoToDomain(swapiStarshipByNameResponseDto)
          .stream()
          .findFirst()
          .get();
      var starshipId = getStarshipId(starshipByName);

      starshipByName.setStarshipId(starshipId);
      starshipByName.setNumberUnits(numberUnits);

      this.starshipRepositoryPort.setNumberStarshipUnitsByName(StarshipMapper.domainToEntity(starshipByName));
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(STARSHIP_CONST, name);
    }
  }

  @Override
  public void incrementNumberStarshipUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(STARSHIP_CONST);
      }

      var swapiStarshipByNameResponseDto = swapiPort.findStarshipByName(name);
      if (swapiStarshipByNameResponseDto == null || swapiStarshipByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var starship = this.starshipRepositoryPort.findNumberStarshipUnitsByName(name);
      var starshipByName = StarshipByNameMapper.responseDtoToDomain(swapiStarshipByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (starship == null) {
        starshipByName.setStarshipId(getStarshipId(starshipByName));
        starshipByName.setNumberUnits(numberUnits);
        this.starshipRepositoryPort.saveNewStarship(StarshipMapper.domainToEntity(starshipByName));
      } else {
        var total = starship.getNumberUnits() + numberUnits;
        starshipByName.setStarshipId(starship.getStarshipId());
        starshipByName.setNumberUnits(total);
        this.starshipRepositoryPort.incrementNumberStarshipUnitsByName(StarshipMapper.domainToEntity(starshipByName));
      }
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(STARSHIP_CONST, name);
    }
  }

  @Override
  public void decrementNumberStarshipUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(STARSHIP_CONST);
      }

      var swapiStarshipByNameResponseDto = swapiPort.findStarshipByName(name);
      if (swapiStarshipByNameResponseDto == null || swapiStarshipByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var starship = this.starshipRepositoryPort.findNumberStarshipUnitsByName(name);
      var starshipByName = StarshipByNameMapper.responseDtoToDomain(swapiStarshipByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (starship == null) {
        starshipByName.setStarshipId(getStarshipId(starshipByName));
        this.starshipRepositoryPort.saveNewStarship(StarshipMapper.domainToEntity(starshipByName));
      } else {
        var total = starship.getNumberUnits() - numberUnits;

        if (total < 0) {
          total = 0;
        }

        starshipByName.setStarshipId(starship.getStarshipId());
        starshipByName.setNumberUnits(total);
        this.starshipRepositoryPort.decrementNumberStarshipUnitsByName(StarshipMapper.domainToEntity(starshipByName));
      }
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(STARSHIP_CONST, name);
    }
  }

  private int getStarshipId(Starship starship) {
    return Integer.parseInt(starship.getUrl().split("/")[5]);
  }
}
