package com.foodfinder.foodfinderapi.review.interfaces.rest;

import com.foodfinder.foodfinderapi.review.domain.model.queries.GetAllReviewsQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByIdQuery;
import com.foodfinder.foodfinderapi.review.domain.model.queries.GetReviewsByRestaurantNameQuery;
import com.foodfinder.foodfinderapi.review.domain.services.ReviewCommandService;
import com.foodfinder.foodfinderapi.review.domain.services.ReviewQueryService;
import com.foodfinder.foodfinderapi.review.interfaces.rest.resources.CreateReviewResource;
import com.foodfinder.foodfinderapi.review.interfaces.rest.resources.ReviewResource;
import com.foodfinder.foodfinderapi.review.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@RestController
@RequestMapping(value = "/api/v1/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reviews", description = "Review Management Endpoints")
public class ReviewsController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    public ReviewsController(ReviewQueryService reviewQueryService, ReviewCommandService reviewCommandService) {
        this.reviewQueryService = reviewQueryService;
        this.reviewCommandService = reviewCommandService;
    }

    @PostMapping
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource resource) {
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(resource);
        var review = reviewCommandService.handle(createReviewCommand);
        if (review.isEmpty()) return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResource.fromEntity(review.get());
        return new ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResource> getReviewById(@PathVariable Long reviewId) {
        var getReviewByIdQuery = new GetReviewsByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);
        if (review.isEmpty()) return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResource.fromEntity(review.get());
        return ResponseEntity.ok(reviewResource);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResource>> getAllReviews() {
        var getAllReviewsQuery = new GetAllReviewsQuery();
        var reviews = reviewQueryService.handle(getAllReviewsQuery);
        var reviewResources = reviews.stream().map(ReviewResource::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(reviewResources);
    }

    @GetMapping("/restaurant/{restaurantName}")
    public ResponseEntity<List<ReviewResource>> getReviewsByRestaurantName(@PathVariable String restaurantName) {
        var getReviewsByRestaurantNameQuery = new GetReviewsByRestaurantNameQuery(restaurantName);
        var reviews = reviewQueryService.handle(getReviewsByRestaurantNameQuery);
        var reviewResources = reviews.stream().map(ReviewResource::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(reviewResources);
    }
}
