package com.foodfinder.foodfinderapi.review.domain.services;

import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetAllReviewsQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByIdQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByQualification;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByRestaurantNameQuery;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {

    Optional<Review> handle(GetReviewsByIdQuery query);

    List<Review> handle(GetAllReviewsQuery query);
    Optional<Review> handle(GetReviewsByQualification query);
    List<Review> handle(GetReviewsByRestaurantNameQuery query);
}
