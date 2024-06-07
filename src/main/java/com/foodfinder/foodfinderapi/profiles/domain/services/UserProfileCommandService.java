package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.UserProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;

import java.util.Optional;

public interface UserProfileCommandService {
    Optional<UserProfile> handle(CreateUserProfileCommand command);
}
