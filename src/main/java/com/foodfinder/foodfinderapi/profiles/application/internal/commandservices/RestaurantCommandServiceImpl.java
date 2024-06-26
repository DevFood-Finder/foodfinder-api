package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateRestaurantCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantCommandService;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantCommandServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant handle(UpdateRestaurantCommand command) {
        return restaurantRepository.findById(command.id())
                .map(restaurant -> {
                    restaurant.setRestaurantName(command.updatedRestaurant().getRestaurantName());
                    restaurant.setPhone(command.updatedRestaurant().getPhone());
                    restaurant.setStreet(command.updatedRestaurant().getStreet());
                    restaurant.setNumber(command.updatedRestaurant().getNumber());
                    restaurant.setPostalCode(command.updatedRestaurant().getPostalCode());
                    restaurant.setCity(command.updatedRestaurant().getCity());
                    restaurant.setCountry(command.updatedRestaurant().getCountry());

                    return restaurantRepository.save(restaurant);
                })
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }
}
