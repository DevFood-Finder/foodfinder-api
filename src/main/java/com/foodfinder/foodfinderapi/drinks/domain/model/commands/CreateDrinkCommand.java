package com.foodfinder.foodfinderapi.drinks.domain.model.commands;

public record CreateDrinkCommand(String drinkName,String drinkDescription,double price) {
    public CreateDrinkCommand {
        if (drinkName== null|| drinkName.isBlank()){
            throw new IllegalArgumentException("drinkName cannot be null or empty");
        }
        if (drinkDescription==null|| drinkDescription.isBlank()){
            throw new IllegalArgumentException("drinkDescription cannot be null or empty");
        }
        if (price<=0){
            throw new IllegalArgumentException("price cannot be negative");
        }
    }
}
