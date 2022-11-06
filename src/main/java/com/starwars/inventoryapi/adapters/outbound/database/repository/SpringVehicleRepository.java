package com.starwars.inventoryapi.adapters.outbound.database.repository;

import com.starwars.inventoryapi.adapters.outbound.database.entities.VehicleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringVehicleRepository extends JpaRepository<VehicleEntity, Integer> {

  Optional<VehicleEntity> findByName(String name);

}
