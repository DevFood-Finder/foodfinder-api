package com.foodfinder.foodfinderapi.security.domain.model.entity;

import jakarta.persistence.AssociationOverride;

public enum Role {
    ROLE_CLIENT,
    ROLE_RESTAURANT,
    ROLE_RECRUITER;
}
