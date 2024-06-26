package com.foodfinder.foodfinderapi.review.interfaces.rest.transform;


import com.foodfinder.foodfinderapi.review.domain.model.commands.CreateReviewCommand;
import com.foodfinder.foodfinderapi.review.interfaces.rest.resources.CreateReviewResource;

public class CreateReviewCommandFromResourceAssembler {
    public static CreateReviewCommand toCommandFromResource(CreateReviewResource resource) {
        return new CreateReviewCommand(resource.description(), resource.qualification(), resource.clientId(), resource.restaurantName());
    }
}