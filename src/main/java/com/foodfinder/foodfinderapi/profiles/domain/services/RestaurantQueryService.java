package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllRestaurantsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetRestaurantByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> handle(GetRestaurantByIdQuery query);

    List<Restaurant> handle(GetAllRestaurantsQuery query);
}
