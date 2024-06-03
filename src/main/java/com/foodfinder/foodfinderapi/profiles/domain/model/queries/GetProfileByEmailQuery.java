package com.foodfinder.foodfinderapi.profiles.domain.model.queries;

import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
