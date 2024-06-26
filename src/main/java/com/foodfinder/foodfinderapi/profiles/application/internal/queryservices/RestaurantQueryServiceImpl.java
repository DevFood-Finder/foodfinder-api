package com.foodfinder.foodfinderapi.profiles.application.internal.queryservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllRestaurantsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetRestaurantByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantQueryService;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantQueryServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByIdQuery query) {
        return restaurantRepository.findById(query.id());
    }

    @Override
    public List<Restaurant> handle(GetAllRestaurantsQuery query) {
        return restaurantRepository.findAll();
    }
}
