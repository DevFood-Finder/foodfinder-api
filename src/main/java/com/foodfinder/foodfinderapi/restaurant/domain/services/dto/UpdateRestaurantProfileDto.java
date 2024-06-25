package com.foodfinder.foodfinderapi.restaurant.domain.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRestaurantProfileDto {
    private String linkedInUrl;
    private String portfolioUrl;
}
