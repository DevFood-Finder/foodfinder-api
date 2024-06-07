package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.UserProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserProfileQueryService {
    List<UserProfile> handle(GetAllProfilesQuery query);

    Optional<UserProfile> handle(GetProfileByIdQuery query);

    Optional<UserProfile> handle(GetProfileByEmailQuery query);
}
