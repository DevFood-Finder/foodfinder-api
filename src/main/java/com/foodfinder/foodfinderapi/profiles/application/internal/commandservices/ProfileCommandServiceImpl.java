package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.Profile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.services.ProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + emailAddress +
                    " already exists");
        });
        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
