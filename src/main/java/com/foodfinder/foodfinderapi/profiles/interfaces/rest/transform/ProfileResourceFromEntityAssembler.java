package com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.RestaurantProfile;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(RestaurantProfile entity) {
        return new ProfileResource(entity.getId(), entity.RestaurantName(),  entity.FullName(), entity.getEmailAddress(),
                entity.getStreetAddress());
    }
}
