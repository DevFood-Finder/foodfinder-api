package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.UserProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileCommandServiceImpl implements UserProfileCommandService {
    private final UserProfileRepository UserProfileRepository;

    public UserProfileCommandServiceImpl(UserProfileRepository userProfileRepository) {
        this.UserProfileRepository = userProfileRepository;
    }


    @Override
    public Optional<UserProfile> handle(CreateUserProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        UserProfileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + emailAddress +
                    " already exists");
        });
        var profile = new UserProfile(command);
        UserProfileRepository.save(profile);
        return Optional.of(profile);
    }
}
