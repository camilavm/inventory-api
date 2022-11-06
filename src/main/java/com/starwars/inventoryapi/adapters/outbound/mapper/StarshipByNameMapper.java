package com.starwars.inventoryapi.adapters.outbound.mapper;

import static java.util.Optional.ofNullable;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.dto.StarshipResponseDto;
import com.starwars.inventoryapi.application.core.domain.Starship;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StarshipByNameMapper {

  public List<Starship> responseDtoToDomain(StarshipByNameResponseDto starshipByNameResponseDto) {
      return ofNullable(starshipByNameResponseDto.getResults())
          .orElse(null)
          .stream()
          .map(StarshipByNameMapper::responseDtoToDomain)
          .toList();
  }

  private static Starship responseDtoToDomain(final StarshipResponseDto starshipResponseDto) {
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
}
