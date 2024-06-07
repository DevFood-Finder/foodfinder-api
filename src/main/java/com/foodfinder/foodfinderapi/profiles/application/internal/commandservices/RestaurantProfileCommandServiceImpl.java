package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateRestaurantProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.RestaurantProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantProfileCommandServiceImpl implements RestaurantProfileCommandService {
    private final RestaurantProfileRepository restaurantProfileRepository;

    public RestaurantProfileCommandServiceImpl(RestaurantProfileRepository restaurantProfileRepository) {
        this.restaurantProfileRepository = restaurantProfileRepository;
    }


    @Override
    public Optional<RestaurantProfile> handle(CreateRestaurantProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        restaurantProfileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Restaurant Profile with email " + emailAddress +
                    " already exists");
        });
        var profile = new RestaurantProfile(command);
        restaurantProfileRepository.save(profile);
        return Optional.of(profile);
    }
}
