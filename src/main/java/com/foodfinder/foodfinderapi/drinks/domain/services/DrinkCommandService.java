package com.foodfinder.foodfinderapi.drinks.domain.services;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.CreateDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.DeleteDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.UpdateDrinkCommand;

import java.util.Optional;

public interface DrinkCommandService {
    Optional<Drink> handle(CreateDrinkCommand command);
    Optional<Drink> handle(UpdateDrinkCommand command);
    void handle(DeleteDrinkCommand command);

}
