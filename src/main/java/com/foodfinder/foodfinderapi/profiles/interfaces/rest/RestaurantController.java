package com.foodfinder.foodfinderapi.profiles.interfaces.rest;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateRestaurantCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllRestaurantsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetRestaurantByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.RestaurantQueryService;

import com.foodfinder.foodfinderapi.profiles.interfaces.rest.dto.UpdateRestaurantProfileDto;
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

    private final RestaurantQueryService restaurantQueryService;
    private final RestaurantCommandService restaurantCommandService;

    @Operation(summary = "Get all Restaurants", responses = {
            @ApiResponse(description = "All Restaurants found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Restaurant.class)))
    })
    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        return restaurantQueryService.handle(getAllRestaurantsQuery);
    }

    @Operation(summary = "Get Restaurant by id", responses = {
            @ApiResponse(description = "Restaurant found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Restaurant.class)))
    })
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(id);
        return restaurantQueryService.handle(getRestaurantByIdQuery).orElse(null);
    }

    @Operation(summary = "Update Restaurant profile", responses = {
            @ApiResponse(description = "Restaurant found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UpdateRestaurantProfileDto.class)))
    })
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody UpdateRestaurantProfileDto updatedRestaurant) {
        var updateRestaurantCommand = new UpdateRestaurantCommand(id, updatedRestaurant);
        return restaurantCommandService.handle(updateRestaurantCommand);
    }

}
