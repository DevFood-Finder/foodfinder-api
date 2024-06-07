package com.foodfinder.foodfinderapi.drinks.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.resources.DrinkResource;

public class DrinkResourceFromEntityAssembler {
    public static DrinkResource toResourceFromEntity(Drink entity) {

        return new DrinkResource(entity.getId(),entity.getDrinkName(),entity.getDrinkDescription(),entity.getPrice());
    }
}
