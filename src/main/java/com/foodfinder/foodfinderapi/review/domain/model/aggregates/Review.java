package com.foodfinder.foodfinderapi.review.domain.model.aggregates;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer qualification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Constructor por defecto
    public Review() {
    }

    public Review(String description, Integer qualification,Client client, Restaurant restaurant) {
        this.description = description;
        this.qualification = qualification;
        this.client = client;
        this.restaurant = restaurant;
    }

}
