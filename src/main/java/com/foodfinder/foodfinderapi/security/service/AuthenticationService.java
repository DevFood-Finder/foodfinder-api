package com.foodfinder.foodfinderapi.security.service;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Restaurant;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.security.domain.model.entity.*;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import com.foodfinder.foodfinderapi.security.domain.persistence.UserRepository;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.ClientRepository;
import com.foodfinder.foodfinderapi.security.service.dto.AuthenticationRequestDto;
import com.foodfinder.foodfinderapi.security.service.dto.AuthenticationResponseDto;
import com.foodfinder.foodfinderapi.security.service.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final ClientRepository clientRepository;

    private final RestaurantRepository restaurantRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponseDto register(RegisterRequestDto registerRequestDto, Role role) {

        if(userRepository.existsByEmail(registerRequestDto.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        if(!registerRequestDto.getPassword().matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$")){
            throw new RuntimeException("Password must contain at least one letter, at least one number, and be longer than six characters");
        }

        if(!registerRequestDto.getEmail().matches("^(.+)@(.+)$")){
            throw new RuntimeException("Email is not valid");
        }

        if(role.equals(Role.ROLE_CLIENT)){
            System.out.println("Password length: " + registerRequestDto.getPassword().length());
            String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
            System.out.println("Encoded password length: " + encodedPassword.length());
            var client = Client.builder()
                    .firstname(registerRequestDto.getFirstname())
                    .lastname(registerRequestDto.getLastname())
                    .email(registerRequestDto.getEmail())
                    .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                    .street(registerRequestDto.getStreet())
                    .number(registerRequestDto.getNumber())
                    .postalCode(registerRequestDto.getPostalCode())
                    .city(registerRequestDto.getCity())
                    .country(registerRequestDto.getCountry())
                    .role(role)
                    .build();
            clientRepository.save(client);
            var jwtToken = jwtService.generateToken(client);
            return AuthenticationResponseDto.builder()
                    .token(jwtToken)
                    .user(client)
                    .build();
        } else {
            var restaurant = Restaurant.builder()
                    .firstname(registerRequestDto.getFirstname())
                    .lastname(registerRequestDto.getLastname())
                    .email(registerRequestDto.getEmail())
                    .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                    .street(registerRequestDto.getStreet())
                    .number(registerRequestDto.getNumber())
                    .postalCode(registerRequestDto.getPostalCode())
                    .city(registerRequestDto.getCity())
                    .country(registerRequestDto.getCountry())
                    .role(role)
                    .build();
            restaurantRepository.save(restaurant);
            var jwtToken = jwtService.generateToken(restaurant);
            return AuthenticationResponseDto.builder()
                    .token(jwtToken)
                    .user(restaurant)
                    .build();
        }
    }


    public AuthenticationResponseDto login(AuthenticationRequestDto registerRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            registerRequest.getEmail(),
                            registerRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException("Email or password is incorrect");
        }

        var user = userRepository.findByEmail(registerRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email or password is incorrect"));

        var restaurant = restaurantRepository.findByEmail(registerRequest.getEmail()).orElse(null);
        var client = clientRepository.findByEmail(registerRequest.getEmail()).orElse(null);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }
}
