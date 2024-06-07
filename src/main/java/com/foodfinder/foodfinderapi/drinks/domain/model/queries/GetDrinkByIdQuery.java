package com.foodfinder.foodfinderapi.drinks.domain.model.queries;

public record GetDrinkByIdQuery(Long id) {
    public GetDrinkByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("drinkId cannot be null");
        }
    }
}
