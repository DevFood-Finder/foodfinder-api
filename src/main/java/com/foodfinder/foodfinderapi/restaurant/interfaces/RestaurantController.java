package com.foodfinder.foodfinderapi.restaurant.interfaces;

import com.foodfinder.foodfinderapi.restaurant.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.restaurant.domain.services.RestaurantService;
import com.foodfinder.foodfinderapi.restaurant.domain.services.dto.UpdateRestaurantProfileDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Restaurant", description = "Edit and view Restaurant information")
@RestController
@RequestMapping("/api/v1/Restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Operation(summary = "Get all Restaurants", responses = {
            @ApiResponse(description = "All Restaurants found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Restaurant.class)))
    })
    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Operation(summary = "Get Restaurant by id", responses = {
            @ApiResponse(description = "Restaurant found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Restaurant.class)))
    })
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id).orElse(null);
    }

    @Operation(summary = "Update Restaurant professional profile", responses = {
            @ApiResponse(description = "Restaurant found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateRestaurantProfileDto.class)))
    })
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody UpdateRestaurantProfileDto updatedRestaurant) {
        return restaurantService.updateRestaurant(id, updatedRestaurant);
    }

}