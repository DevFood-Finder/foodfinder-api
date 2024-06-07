package com.foodfinder.foodfinderapi.profiles.domain.model.commands;

public record CreateUserProfileCommand(String firstName, String lastName,
                                       String email) {
}
