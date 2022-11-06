package com.starwars.inventoryapi.adapters.outbound.config;

import com.starwars.inventoryapi.application.core.usecase.StarshipUseCase;
import com.starwars.inventoryapi.application.core.usecase.VehicleUseCase;
import com.starwars.inventoryapi.application.core.usecase.ports.input.StarshipUseCasePort;
import com.starwars.inventoryapi.application.core.usecase.ports.input.VehicleUseCasePort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.StarshipRepositoryPort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.SwapiPort;
import com.starwars.inventoryapi.application.core.usecase.ports.output.VehicleRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  StarshipUseCasePort starshipUseCase(StarshipRepositoryPort starshipRepositoryPort,
                                      SwapiPort swapiPort) {
    return new StarshipUseCase(starshipRepositoryPort, swapiPort);
  }

  @Bean
  VehicleUseCasePort vehicleUseCase(VehicleRepositoryPort vehicleRepositoryPort,
                                    SwapiPort swapiPort) {
    return new VehicleUseCase(vehicleRepositoryPort, swapiPort);
  }

}
