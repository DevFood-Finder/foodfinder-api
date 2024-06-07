package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantProfileQueryService {
    List<RestaurantProfile> handle(GetAllProfilesQuery query);

    Optional<RestaurantProfile> handle(GetProfileByIdQuery query);

    Optional<RestaurantProfile> handle(GetProfileByEmailQuery query);
}
