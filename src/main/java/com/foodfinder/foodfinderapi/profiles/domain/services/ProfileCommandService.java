package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.Profile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
