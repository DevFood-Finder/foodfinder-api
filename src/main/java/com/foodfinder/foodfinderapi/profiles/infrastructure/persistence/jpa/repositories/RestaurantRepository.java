package com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    Optional<Restaurant> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<Restaurant> findByRestaurantName(String restaurantName);
    Boolean existsByRestaurantName(String restaurantName);
}
