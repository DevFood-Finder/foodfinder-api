package com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record OwnerName(String firstName, String lastName) {
    public OwnerName(){this(null,null);}

    public OwnerName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }

    public String getFullName(){
        return String.format("%s %s", firstName,lastName);
    }

}
