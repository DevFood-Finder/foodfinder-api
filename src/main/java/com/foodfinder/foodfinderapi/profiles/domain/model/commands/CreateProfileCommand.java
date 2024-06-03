package com.foodfinder.foodfinderapi.profiles.domain.model.commands;

public record CreateProfileCommand(String firstName, String LastName,
                                   String email, String street, String number,
                                   String city, String postalCode, String country) {
}
