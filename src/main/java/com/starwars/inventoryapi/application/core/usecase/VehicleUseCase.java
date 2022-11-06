package com.starwars.inventoryapi.application.core.usecase;

import com.starwars.inventoryapi.adapters.outbound.dto.VehicleResponseDto;
import com.starwars.inventoryapi.adapters.outbound.mapper.VehicleByNameMapper;
import com.starwars.inventoryapi.adapters.outbound.mapper.VehicleMapper;
import com.starwars.inventoryapi.application.core.domain.Vehicle;
import com.starwars.inventoryapi.application.core.exception.InvalidNumberUnitsException;
import com.starwars.inventoryapi.application.core.exception.SwapiNotFoundException;
import com.starwars.inventoryapi.application.core.usecase.ports.input.VehicleUseCasePort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.SwapiPort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.VehicleRepositoryPort;
import org.springframework.data.crossstore.ChangeSetPersister;

public class VehicleUseCase implements VehicleUseCasePort {

  private static final String VEHICLE_CONST = "vehicle";

  private final VehicleRepositoryPort vehicleRepositoryPort;
  private final SwapiPort swapiPort;

  public VehicleUseCase(final VehicleRepositoryPort vehicleRepositoryPort,
                        final SwapiPort swapiPort) {
    this.vehicleRepositoryPort = vehicleRepositoryPort;
    this.swapiPort = swapiPort;
  }

  @Override
  public VehicleResponseDto findNumberVehicleUnitsByName(final String name) {
    try {
      var swapiVehicleByNameResponseDto = swapiPort.findVehicleByName(name);
      if (swapiVehicleByNameResponseDto == null || swapiVehicleByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var vehicle = this.vehicleRepositoryPort.findNumberVehicleUnitsByName(name);
      var vehicleByName = VehicleByNameMapper.responseDtoToDomain(swapiVehicleByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (vehicle == null) {
        vehicleByName.setVehicleId(getVehicleId(vehicleByName));
        this.vehicleRepositoryPort.saveNewVehicle(VehicleMapper.domainToEntity(vehicleByName));
      } else {
        vehicleByName.setNumberUnits(vehicle.getNumberUnits());
      }

      return VehicleMapper.domainToResponseDto(vehicleByName);
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(VEHICLE_CONST, name);
    }
  }

  @Override
  public void setNumberVehicleUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(VEHICLE_CONST);
      }

      var swapiVehicleByNameResponseDto = swapiPort.findVehicleByName(name);
      if (swapiVehicleByNameResponseDto == null || swapiVehicleByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var vehicleByName = VehicleByNameMapper.responseDtoToDomain(swapiVehicleByNameResponseDto)
          .stream()
          .findFirst()
          .get();
      var vehicleId = getVehicleId(vehicleByName);

      vehicleByName.setVehicleId(vehicleId);
      vehicleByName.setNumberUnits(numberUnits);

      this.vehicleRepositoryPort.setNumberVehicleUnitsByName(VehicleMapper.domainToEntity(vehicleByName));
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(VEHICLE_CONST, name);
    }
  }

  @Override
  public void incrementNumberVehicleUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(VEHICLE_CONST);
      }

      var swapiVehicleByNameResponseDto = swapiPort.findVehicleByName(name);
      if (swapiVehicleByNameResponseDto == null || swapiVehicleByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var vehicle = this.vehicleRepositoryPort.findNumberVehicleUnitsByName(name);
      var vehicleByName = VehicleByNameMapper.responseDtoToDomain(swapiVehicleByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (vehicle == null) {
        vehicleByName.setVehicleId(getVehicleId(vehicleByName));
        vehicleByName.setNumberUnits(numberUnits);
        this.vehicleRepositoryPort.saveNewVehicle(VehicleMapper.domainToEntity(vehicleByName));
      } else {
        var total = vehicle.getNumberUnits() + numberUnits;
        vehicleByName.setVehicleId(vehicle.getVehicleId());
        vehicleByName.setNumberUnits(total);
        this.vehicleRepositoryPort.incrementNumberVehicleUnitsByName(VehicleMapper.domainToEntity(vehicleByName));
      }
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(VEHICLE_CONST, name);
    }
  }

  @Override
  public void decrementNumberVehicleUnitsByName(final String name, final int numberUnits) {
    try {
      if (numberUnits < 0) {
        throw new InvalidNumberUnitsException(VEHICLE_CONST);
      }

      var swapiVehicleByNameResponseDto = swapiPort.findVehicleByName(name);
      if (swapiVehicleByNameResponseDto == null || swapiVehicleByNameResponseDto.getResults().isEmpty()) {
        throw new ChangeSetPersister.NotFoundException();
      }

      var vehicle = this.vehicleRepositoryPort.findNumberVehicleUnitsByName(name);
      var vehicleByName = VehicleByNameMapper.responseDtoToDomain(swapiVehicleByNameResponseDto)
          .stream()
          .findFirst()
          .get();

      if (vehicle == null) {
        vehicleByName.setVehicleId(getVehicleId(vehicleByName));
        this.vehicleRepositoryPort.saveNewVehicle(VehicleMapper.domainToEntity(vehicleByName));
      } else {
        var total = vehicle.getNumberUnits() - numberUnits;

        if (total < 0) {
          total = 0;
        }

        vehicleByName.setVehicleId(vehicle.getVehicleId());
        vehicleByName.setNumberUnits(total);
        this.vehicleRepositoryPort.decrementNumberVehicleUnitsByName(VehicleMapper.domainToEntity(vehicleByName));
      }
    } catch (ChangeSetPersister.NotFoundException e) {
      throw new SwapiNotFoundException(VEHICLE_CONST, name);
    }
  }

  private int getVehicleId(Vehicle vehicle) {
    return Integer.parseInt(vehicle.getUrl().split("/")[5]);
  }
}
