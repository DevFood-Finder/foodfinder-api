package com.foodfinder.foodfinderapi.profiles.domain.model.commands;

public record CreateRestaurantProfileCommand(String Name, String firstName, String lastName,
                                             String email, String street, String number,
                                             String city, String postalCode, String country) {
}