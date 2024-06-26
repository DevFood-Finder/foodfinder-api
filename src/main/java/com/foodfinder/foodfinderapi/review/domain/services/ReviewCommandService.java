package com.foodfinder.foodfinderapi.review.domain.services;

import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import com.foodfinder.foodfinderapi.review.domain.model.commands.CreateReviewCommand;

import java.util.Optional;

public interface ReviewCommandService {
    Optional<Review> handle(CreateReviewCommand command);
}
