package com.foodfinder.foodfinderapi.profiles.interfaces.rest;

import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileQueryService;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.CreateUserProfileResource;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.UserProfileResource;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform.CreateUserProfileCommandFromResourceAssembler;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform.UserProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/userProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class UserProfilesController {
    private final UserProfileQueryService profileQueryService;
    private final UserProfileCommandService userProfileCommandService;

    public UserProfilesController(UserProfileQueryService profileQueryService,
                                  UserProfileCommandService userProfileCommandService) {
        this.profileQueryService = profileQueryService;
        this.userProfileCommandService = userProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<UserProfileResource> createProfile(@RequestBody CreateUserProfileResource resource) {
        var createUserProfileCommand = CreateUserProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = userProfileCommandService.handle(createUserProfileCommand);
        if (profile.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = UserProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<UserProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = UserProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping
    public ResponseEntity<List<UserProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream()
                .map(UserProfileResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }
}
