package com.foodfinder.foodfinderapi.profiles.application.internal.queryservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantProfileQueryService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.RestaurantProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantProfileQueryServiceImpl implements RestaurantProfileQueryService {
    private final RestaurantProfileRepository restaurantProfileRepository;

    public RestaurantProfileQueryServiceImpl(RestaurantProfileRepository restaurantProfileRepository) {
        this.restaurantProfileRepository = restaurantProfileRepository;
    }


    @Override
    public List<RestaurantProfile> handle(GetAllProfilesQuery query) {
        return restaurantProfileRepository.findAll();
    }

    @Override
    public Optional<RestaurantProfile> handle(GetProfileByIdQuery query) {
        return restaurantProfileRepository.findById(query.profileId());
    }

    @Override
    public Optional<RestaurantProfile> handle(GetProfileByEmailQuery query) {
        return restaurantProfileRepository.findByEmail(query.emailAddress());
    }
}
