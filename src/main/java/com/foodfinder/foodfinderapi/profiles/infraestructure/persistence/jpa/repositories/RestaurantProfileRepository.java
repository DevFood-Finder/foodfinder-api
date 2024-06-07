package com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantProfileRepository extends JpaRepository<RestaurantProfile, Long> {
    Optional<RestaurantProfile> findByEmail(EmailAddress emailAddress);
}
