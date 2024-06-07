package com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.UserProfile;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.UserProfileResource;

public class UserProfileResourceFromEntityAssembler {
    public static UserProfileResource toResourceFromEntity(UserProfile entity) {
        return new UserProfileResource(entity.getId(), entity.FullName(), entity.getEmailAddress());
    }
}
