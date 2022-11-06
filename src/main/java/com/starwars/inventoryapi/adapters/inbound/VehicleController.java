package com.starwars.inventoryapi.adapters.inbound;

import com.starwars.inventoryapi.adapters.inbound.dto.UnitsRequestDto;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleResponseDto;
import com.starwars.inventoryapi.application.core.usecase.ports.input.VehicleUseCasePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

  private final VehicleUseCasePort vehicleUseCasePort;

  public VehicleController(final VehicleUseCasePort vehicleUseCasePort) {
    this.vehicleUseCasePort = vehicleUseCasePort;
  }

  @GetMapping("/")
  public VehicleResponseDto findNumberVehicleUnitsByName(@RequestParam final String search) {
    return vehicleUseCasePort.findNumberVehicleUnitsByName(search);
  }

  @PatchMapping("/set/")
  public void setNumberVehicleUnitsByName(@RequestParam final String search,
                                          @RequestBody final UnitsRequestDto unitsRequestDto) {
    vehicleUseCasePort.setNumberVehicleUnitsByName(search, unitsRequestDto.getNumberUnits());
  }

  @PatchMapping("/increment/")
  public void incrementNumberVehicleUnitsByName(@RequestParam final String search,
                                                @RequestBody final UnitsRequestDto unitsRequestDto) {
    vehicleUseCasePort.incrementNumberVehicleUnitsByName(search, unitsRequestDto.getNumberUnits());
  }

  @PatchMapping("/decrement/")
  public void decrementNumberVehicleUnitsByName(@RequestParam final String search,
                                                @RequestBody final UnitsRequestDto unitsRequestDto) {
    vehicleUseCasePort.decrementNumberVehicleUnitsByName(search, unitsRequestDto.getNumberUnits());
  }
}
