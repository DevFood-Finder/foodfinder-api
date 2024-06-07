package com.foodfinder.foodfinderapi.drinks.interfaces.rest.resources;

public record CreateDrinkResource(String drinkName, String drinkDescription, double price) {
    public CreateDrinkResource{
        if (drinkName==null){
            throw new IllegalArgumentException("drinkName cannot be null");
        }
        if (drinkDescription==null){
            throw new IllegalArgumentException("drinkDescription cannot be null");
        }
        if (price<0){
            throw new IllegalArgumentException("price cannot be negative");
        }
    }
}
