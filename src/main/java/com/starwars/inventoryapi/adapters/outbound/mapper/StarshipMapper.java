package com.starwars.inventoryapi.adapters.outbound.mapper;

import com.starwars.inventoryapi.adapters.outbound.database.entities.StarshipEntity;
import com.starwars.inventoryapi.adapters.outbound.dto.StarshipResponseDto;
import com.starwars.inventoryapi.application.core.domain.Starship;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StarshipMapper {

  public Starship entityToDomain(StarshipEntity starshipEntity) {
    return Starship.builder()
        .starshipId(starshipEntity.getStarshipId())
        .name(starshipEntity.getName())
        .model(starshipEntity.getModel())
        .numberUnits(starshipEntity.getNumberUnits())
        .build();
  }

  public StarshipEntity domainToEntity(Starship starship) {
    return StarshipEntity.builder()
        .starshipId(starship.getStarshipId())
        .name(starship.getName())
        .model(starship.getModel())
        .numberUnits(starship.getNumberUnits())
        .build();
  }

  public Starship responseDtoToDomain(final StarshipResponseDto starshipResponseDto) {
    return Starship.builder()
        .name(starshipResponseDto.getName())
        .model(starshipResponseDto.getModel())
        .starshipClass(starshipResponseDto.getStarshipClass())
        .manufacturer(starshipResponseDto.getManufacturer())
        .costInCredits(starshipResponseDto.getCostInCredits())
        .length(starshipResponseDto.getLength())
        .crew(starshipResponseDto.getCrew())
        .passengers(starshipResponseDto.getPassengers())
        .maxAtmospheringSpeed(starshipResponseDto.getMaxAtmospheringSpeed())
        .hyperdriveRating(starshipResponseDto.getHyperdriveRating())
        .MGLT(starshipResponseDto.getMGLT())
        .cargoCapacity(starshipResponseDto.getCargoCapacity())
        .consumables(starshipResponseDto.getConsumables())
        .films(starshipResponseDto.getFilms())
        .pilots(starshipResponseDto.getPilots())
        .url(starshipResponseDto.getUrl())
        .created(starshipResponseDto.getCreated())
        .edited(starshipResponseDto.getEdited())
        .numberUnits(starshipResponseDto.getNumberUnits())
        .build();
  }

  public StarshipResponseDto domainToResponseDto(final Starship starship) {
    return StarshipResponseDto.builder()
        .name(starship.getName())
        .model(starship.getModel())
        .starshipClass(starship.getStarshipClass())
        .manufacturer(starship.getManufacturer())
        .costInCredits(starship.getCostInCredits())
        .length(starship.getLength())
        .crew(starship.getCrew())
        .passengers(starship.getPassengers())
        .maxAtmospheringSpeed(starship.getMaxAtmospheringSpeed())
        .hyperdriveRating(starship.getHyperdriveRating())
        .MGLT(starship.getMGLT())
        .cargoCapacity(starship.getCargoCapacity())
        .consumables(starship.getConsumables())
        .films(starship.getFilms())
        .pilots(starship.getPilots())
        .url(starship.getUrl())
        .created(starship.getCreated())
        .edited(starship.getEdited())
        .numberUnits(starship.getNumberUnits())
        .build();
  }
}
