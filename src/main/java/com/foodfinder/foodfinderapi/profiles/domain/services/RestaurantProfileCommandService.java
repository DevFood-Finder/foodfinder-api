package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateRestaurantProfileCommand;

import java.util.Optional;

public interface RestaurantProfileCommandService {
    Optional<RestaurantProfile> handle(CreateRestaurantProfileCommand command);
}
