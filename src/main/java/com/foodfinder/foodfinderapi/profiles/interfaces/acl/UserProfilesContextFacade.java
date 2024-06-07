package com.foodfinder.foodfinderapi.profiles.interfaces.acl;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileQueryService;
import org.springframework.stereotype.Service;

/**
 * Service Facade for the profile context.
 *
 * <p>
 *     It is used by the other contexts to interact with the Profile Context.
 *     It is implemented as part of an anti-corruption layer (ACL) to be consumed by other contexts.
 * </p>
 */
@Service
public class UserProfilesContextFacade {
    private final UserProfileCommandService userProfileCommandService;
    private final UserProfileQueryService userprofileQueryService;

    public UserProfilesContextFacade(UserProfileCommandService userProfileCommandService, UserProfileQueryService userprofileQueryService) {
        this.userProfileCommandService = userProfileCommandService;
        this.userprofileQueryService = userprofileQueryService;
    }

    /**
     * Creates a new Profile
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @return the profile id
     */
    public Long createProfile(String name, String firstName, String lastName, String email) {
        var createProfileCommand = new CreateUserProfileCommand(name, firstName, lastName, email);
        var profile = userProfileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    /**
     * Fetches the profile id by email
     * @param email the email
     * @return the profile id
     */
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = userprofileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

}
