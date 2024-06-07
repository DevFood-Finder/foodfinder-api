package com.foodfinder.foodfinderapi.drinks.domain.model.commands;

public record UpdateDrinkCommand(Long drinkId, String drinkName, String drinkDescription,double price) {
}
