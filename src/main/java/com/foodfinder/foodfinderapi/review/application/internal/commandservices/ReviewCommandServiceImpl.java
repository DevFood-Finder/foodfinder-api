package com.foodfinder.foodfinderapi.review.application.internal.commandservices;


import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.ClientRepository;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import com.foodfinder.foodfinderapi.review.domain.model.commands.CreateReviewCommand;
import com.foodfinder.foodfinderapi.review.domain.services.ReviewCommandService;
import com.foodfinder.foodfinderapi.review.infrastructure.persistence.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final ClientRepository clientRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository, ClientRepository clientRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.clientRepository = clientRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Review> handle(CreateReviewCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        var restaurant = restaurantRepository.findByRestaurantName(command.restaurantName())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        var review = new Review(command.description(), command.qualification(), client, restaurant);
        var createdReview = reviewRepository.save(review);
        return Optional.of(createdReview);
    }
}
