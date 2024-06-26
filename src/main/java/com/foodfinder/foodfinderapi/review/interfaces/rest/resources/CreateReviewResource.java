package com.foodfinder.foodfinderapi.review.interfaces.rest.resources;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;

public record CreateReviewResource(String description, Integer qualification, Long clientId, String restaurantName) {
    public CreateReviewResource {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("descripcion no puede ser nulo");
        }
        if (qualification == null) {
            throw new IllegalArgumentException("valoracion no puede ser nulo");
        }
        if (clientId == null) {
            throw new IllegalArgumentException("client no puede ser nulo");
        }
        if (restaurantName == null || restaurantName.isEmpty()) {
            throw new IllegalArgumentException("restaurantName cannot be null");
        }
    }
}
