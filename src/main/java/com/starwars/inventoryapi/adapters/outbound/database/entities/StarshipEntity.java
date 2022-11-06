package com.starwars.inventoryapi.adapters.outbound.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "starship")
public class StarshipEntity {

  @Id
  @Column(name="starship_id", nullable=false)
  private int starshipId;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="model", nullable=false)
  private String model;

  @Column(name="number_units", nullable=false)
  private int numberUnits;

}
