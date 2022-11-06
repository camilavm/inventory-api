package com.starwars.inventoryapi.adapters.outbound.feign.client;

import com.starwars.inventoryapi.adapters.outbound.dto.StarshipByNameResponseDto;
import com.starwars.inventoryapi.adapters.outbound.dto.VehicleByNameResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SwapiFeignClient",
             url = "https://swapi.dev/api")
public interface SwapiFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/starships/")
  StarshipByNameResponseDto findSwapiStarshipByName(final @RequestParam("search") String starshipName);

  @RequestMapping(method = RequestMethod.GET, value = "/vehicles/")
  VehicleByNameResponseDto findSwapiVehicleByName(final @RequestParam("search") String vehicleName);
}
