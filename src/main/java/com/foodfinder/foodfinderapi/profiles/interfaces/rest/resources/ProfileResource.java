package com.foodfinder.foodfinderapi.profiles.interfaces.rest.resources;

public record ProfileResource(Long id,
                              String restaurantName,
                              String ownerName,
                              String email,
                              String streetAddress) {
}
