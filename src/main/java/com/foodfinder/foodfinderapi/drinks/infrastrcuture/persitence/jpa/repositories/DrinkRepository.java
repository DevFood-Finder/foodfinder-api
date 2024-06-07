package com.foodfinder.foodfinderapi.drinks.infrastrcuture.persitence.jpa.repositories;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Optional<Drink> findByDrinkName(String drinkName);
    boolean existsByDrinkName(String drinkName);
    boolean existsByDrinkNameAndIdNot(String drinkName,Long id);
}
