package com.starwars.inventoryapi.adapters.outbound.database.repository;

import com.starwars.inventoryapi.adapters.outbound.database.entities.StarshipEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringStarshipRepository extends JpaRepository<StarshipEntity, Integer> {

  Optional<StarshipEntity> findByName(String name);

}
