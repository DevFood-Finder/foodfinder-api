package com.foodfinder.foodfinderapi.profiles.interfaces.rest;

import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantProfileCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantProfileQueryService;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.CreateProfileResource;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources.ProfileResource;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/restaurantProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfilesController {
    private final RestaurantProfileQueryService profileQueryService;
    private final RestaurantProfileCommandService restaurantProfileCommandService;

    public ProfilesController(RestaurantProfileQueryService profileQueryService,
                              RestaurantProfileCommandService restaurantProfileCommandService) {
        this.profileQueryService = profileQueryService;
        this.restaurantProfileCommandService = restaurantProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = restaurantProfileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return  ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream()
                .map(ProfileResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(profileResources);
    }
}
