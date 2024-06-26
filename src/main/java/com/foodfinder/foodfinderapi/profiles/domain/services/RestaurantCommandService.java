package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateRestaurantCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;

public interface RestaurantCommandService {
    Restaurant handle(UpdateRestaurantCommand command);
}
