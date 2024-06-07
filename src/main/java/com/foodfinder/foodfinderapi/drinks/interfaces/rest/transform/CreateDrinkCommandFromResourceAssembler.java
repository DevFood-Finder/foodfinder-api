package com.foodfinder.foodfinderapi.drinks.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.drinks.domain.model.commands.CreateDrinkCommand;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.resources.CreateDrinkResource;

public class CreateDrinkCommandFromResourceAssembler {
    public static CreateDrinkCommand toCommandFromResource(CreateDrinkResource resource) {
        return new CreateDrinkCommand(resource.drinkName(),resource.drinkDescription(),resource.price());
    }
}
