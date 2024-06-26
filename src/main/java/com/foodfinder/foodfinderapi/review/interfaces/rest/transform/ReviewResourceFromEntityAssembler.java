package com.foodfinder.foodfinderapi.review.interfaces.rest.transform;


import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import com.foodfinder.foodfinderapi.review.interfaces.rest.resources.ReviewResource;

public class ReviewResourceFromEntityAssembler {
    public static ReviewResource toResourceFromEntity(Review entity) {
        return ReviewResource.fromEntity(entity);
    }
}