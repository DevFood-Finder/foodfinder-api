package com.foodfinder.foodfinderapi.drinks.domain.services;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetAllDrinkQuery;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetDrinkByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DrinkQueryService {
    Optional<Drink> handle(GetDrinkByIdQuery query);
    List<Drink> handle(GetAllDrinkQuery query);
}
