package com.starwars.inventoryapi.adapters.outbound.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarshipByNameResponseDto {

  private List<StarshipResponseDto> results;

}
