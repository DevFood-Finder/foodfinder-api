package com.foodfinder.foodfinderapi.profiles.interfaces.acl;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.services.ProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.ProfileQueryService;
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
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    /**
     * Creates a new Profile
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @param street the street address
     * @param number the number
     * @param city the city
     * @param postalCode the zip code
     * @param country the country
     * @return the profile id
     */
    public Long createProfile(String name, String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
        var createProfileCommand = new CreateProfileCommand(name, firstName, lastName, email, street, number, city, postalCode, country);
        var profile = profileCommandService.handle(createProfileCommand);
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
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

}
