package com.foodfinder.foodfinderapi.profiles.domain.model.commands;

import com.foodfinder.foodfinderapi.profiles.interfaces.rest.dto.UpdateRestaurantProfileDto;

public record UpdateRestaurantCommand(Long id, UpdateRestaurantProfileDto updatedRestaurant) {
}
