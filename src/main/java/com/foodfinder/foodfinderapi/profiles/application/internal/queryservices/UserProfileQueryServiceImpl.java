package com.foodfinder.foodfinderapi.profiles.application.internal.queryservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.aggregates.UserProfile;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllProfilesQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetProfileByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.UserProfileQueryService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileQueryServiceImpl implements UserProfileQueryService {
    private final UserProfileRepository restaurantProfileRepository;

    public UserProfileQueryServiceImpl(UserProfileRepository restaurantProfileRepository) {
        this.restaurantProfileRepository = restaurantProfileRepository;
    }


    @Override
    public List<UserProfile> handle(GetAllProfilesQuery query) {
        return restaurantProfileRepository.findAll();
    }

    @Override
    public Optional<UserProfile> handle(GetProfileByIdQuery query) {
        return restaurantProfileRepository.findById(query.profileId());
    }

    @Override
    public Optional<UserProfile> handle(GetProfileByEmailQuery query) {
        return restaurantProfileRepository.findByEmail(query.emailAddress());
    }
}
