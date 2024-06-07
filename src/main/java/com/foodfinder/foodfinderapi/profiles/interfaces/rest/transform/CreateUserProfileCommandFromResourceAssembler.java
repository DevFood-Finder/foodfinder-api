package com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.CreateUserProfileResource;

public class CreateUserProfileCommandFromResourceAssembler {
    public static CreateUserProfileCommand toCommandFromResource(CreateUserProfileResource resource) {
        return new CreateUserProfileCommand(resource.firstName(),resource.lastName(), resource.email());
    }
}
