package com.foodfinder.foodfinderapi.security.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestDto {
    private String firstname;
    private String lastname;
    private String street;
    private String number;
    private String postalCode;
    private String city;
    private String country;
}
