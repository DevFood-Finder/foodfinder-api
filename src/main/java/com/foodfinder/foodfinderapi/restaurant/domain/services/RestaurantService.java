package com.foodfinder.foodfinderapi.restaurant.domain.services;

import com.foodfinder.foodfinderapi.restaurant.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import com.foodfinder.foodfinderapi.restaurant.domain.services.dto.UpdateRestaurantProfileDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;



    public Optional<Restaurant> getRestaurantById(Long id) {
         return restaurantRepository.findById(id);
     }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long id, UpdateRestaurantProfileDto updatedRestaurant) {
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setPortfolioUrl(updatedRestaurant.getPortfolioUrl());
                    restaurant.setLinkedInUrl(updatedRestaurant.getLinkedInUrl());

                    return restaurantRepository.save(restaurant);
                })
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public Boolean existsByEmail(String email) {
        return restaurantRepository.existsByEmail(email);
    }

}
