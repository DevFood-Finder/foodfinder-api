package com.foodfinder.foodfinderapi.review.application.internal.queryservices;

import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetAllReviewsQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByIdQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByQualification;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByRestaurantNameQuery;
import com.foodfinder.foodfinderapi.review.domain.services.ReviewQueryService;
import com.foodfinder.foodfinderapi.review.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> handle(GetReviewsByIdQuery query) {
        return reviewRepository.findById(query.reviewId());
    }

    @Override
    public List<Review> handle(GetAllReviewsQuery query) {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> handle(GetReviewsByQualification query) {
        return reviewRepository.findByQualification(query.qualification());
    }

    @Override
    public List<Review> handle(GetReviewsByRestaurantNameQuery query) {
        return reviewRepository.findByRestaurantRestaurantName(query.restaurantName());
    }
}
