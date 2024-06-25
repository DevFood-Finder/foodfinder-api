package com.foodfinder.foodfinderapi.security.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePictureUrl;
    private String street;
    private String number;
    private String postalCode;
    private String city;
    private String country;
}
