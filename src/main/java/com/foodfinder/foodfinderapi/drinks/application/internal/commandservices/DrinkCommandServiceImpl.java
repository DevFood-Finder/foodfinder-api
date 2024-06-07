package com.foodfinder.foodfinderapi.drinks.application.internal.commandservices;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.CreateDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.DeleteDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.domain.model.commands.UpdateDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.domain.services.DrinkCommandService;
import com.foodfinder.foodfinderapi.drinks.infrastrcuture.persitence.jpa.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkCommandServiceImpl implements DrinkCommandService {

    private final DrinkRepository drinkRepository;

    public DrinkCommandServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Optional<Drink> handle(CreateDrinkCommand command) {
        if (drinkRepository.existsByDrinkName(command.drinkName())){
            throw new IllegalArgumentException("Drink name already exists");
        }
        var drink= new Drink(command);
        var createdDrinks = drinkRepository.save(drink);
        return Optional.of(createdDrinks);
    }

    @Override
    public Optional<Drink> handle(UpdateDrinkCommand command) {
        return Optional.empty();
    }

    @Override
    public void handle(DeleteDrinkCommand command) {

    }
}
