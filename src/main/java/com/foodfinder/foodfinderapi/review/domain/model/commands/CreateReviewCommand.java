package com.foodfinder.foodfinderapi.review.domain.model.commands;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;

public record CreateReviewCommand (String description, Integer qualification, Long clientId, String restaurantName) {
    public CreateReviewCommand {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("descripcion  cannot be null or empty");
        }
        if (qualification == null) {
            throw new IllegalArgumentException("valoracion cannot be null or empty");
        }
        if (clientId == null) {
            throw new IllegalArgumentException("client cannot be null or empty");
        }
        if (restaurantName == null || restaurantName.isBlank()) {
            throw new IllegalArgumentException("restaurantName cannot be null or empty");
        }
    }

}
