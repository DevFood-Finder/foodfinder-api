package com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RestaurantName(String Name) {
    public RestaurantName() { this(null); }

    public RestaurantName {
        if (Name == null || Name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    public String getFullName(){
        return String.format("%s %s", Name);
    }

}
