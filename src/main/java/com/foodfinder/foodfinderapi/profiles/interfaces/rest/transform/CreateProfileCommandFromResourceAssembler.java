package com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateProfileCommand;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.name(), resource.firstName(),resource.lastName(), resource.email(),
                resource.street(), resource.number(), resource.city(), resource.postalCode(), resource.country());
    }
}
