package com.foodfinder.foodfinderapi.review.interfaces.rest.resources;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;

public record ReviewResource(Long id, String description, Integer qualification, String clientNickname, String restaurantName) {
    public static ReviewResource fromEntity(Review review) {
        return new ReviewResource(
                review.getId(),
                review.getDescription(),
                review.getQualification(),
                review.getClient().getNickName(),
                review.getRestaurant().getRestaurantName()
        );
    }
}