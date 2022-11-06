package com.starwars.inventoryapi.adapters.inbound;

import com.starwars.inventoryapi.adapters.inbound.dto.UnitsRequestDto;
import com.starwars.inventoryapi.adapters.outbound.dto.StarshipResponseDto;
import com.starwars.inventoryapi.application.core.usecase.ports.input.StarshipUseCasePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starships")
public class StarshipController {

  private final StarshipUseCasePort starshipUseCasePort;

  public StarshipController(final StarshipUseCasePort starshipUseCasePort) {
    this.starshipUseCasePort = starshipUseCasePort;
  }

  @GetMapping("/")
  public StarshipResponseDto findNumberStarshipUnitsByName(@RequestParam final String search) {
    return starshipUseCasePort.findNumberStarshipUnitsByName(search);
  }

  @PatchMapping("/set/")
  public void setNumberStarshipUnitsByName(@RequestParam final String search,
                                           @RequestBody final UnitsRequestDto unitsRequestDto) {
    starshipUseCasePort.setNumberStarshipUnitsByName(search, unitsRequestDto.getNumberUnits());
  }

  @PatchMapping("/increment/")
  public void incrementNumberStarshipUnitsByName(@RequestParam final String search,
                                                 @RequestBody final UnitsRequestDto unitsRequestDto) {
    starshipUseCasePort.incrementNumberStarshipUnitsByName(search, unitsRequestDto.getNumberUnits());
  }

  @PatchMapping("/decrement/")
  public void decrementNumberStarshipUnitsByName(@RequestParam final String search,
                                                 @RequestBody final UnitsRequestDto unitsRequestDto) {
    starshipUseCasePort.decrementNumberStarshipUnitsByName(search, unitsRequestDto.getNumberUnits());
  }
}
