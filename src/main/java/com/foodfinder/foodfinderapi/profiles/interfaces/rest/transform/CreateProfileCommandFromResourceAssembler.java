package com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateRestaurantProfileCommand;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateRestaurantProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateRestaurantProfileCommand(resource.name(), resource.firstName(),resource.lastName(), resource.email(),
                resource.street(), resource.number(), resource.city(), resource.postalCode(), resource.country());
    }
}
