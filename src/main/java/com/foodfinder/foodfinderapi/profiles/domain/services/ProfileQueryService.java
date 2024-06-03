package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.Profile;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);

    Optional<Profile> handle(GetProfileByEmailQuery query);
}
