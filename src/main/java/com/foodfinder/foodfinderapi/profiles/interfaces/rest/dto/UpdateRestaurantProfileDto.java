package com.foodfinder.foodfinderapi.profiles.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRestaurantProfileDto {
    private String restaurantName;
    private String phone;
    private String street;
    private String number;
    private String postalCode;
    private String city;
    private String country;
}
