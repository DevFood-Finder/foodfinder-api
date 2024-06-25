package com.foodfinder.foodfinderapi.security.service.dto;

import com.foodfinder.foodfinderapi.restaurant.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.client.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.security.domain.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {
    private String token;
    private User user;
    private Restaurant restaurant;
    private Client client;
}