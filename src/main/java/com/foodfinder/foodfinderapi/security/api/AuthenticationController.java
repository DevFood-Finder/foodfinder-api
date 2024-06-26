package com.foodfinder.foodfinderapi.security.api;

import com.foodfinder.foodfinderapi.security.service.dto.AuthenticationRequestDto;
import com.foodfinder.foodfinderapi.security.service.dto.AuthenticationResponseDto;
import com.foodfinder.foodfinderapi.security.service.dto.RegisterRequestDto;
import com.foodfinder.foodfinderapi.security.domain.model.entity.Role;
import com.foodfinder.foodfinderapi.security.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Register client, Restaurant, and login user")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "Register a client", responses = {
            @ApiResponse(description = "Successfully registered a client",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterRequestDto.class)))
    })
    @PostMapping("/register-client")
    public ResponseEntity<AuthenticationResponseDto> registerClient(
            @RequestBody RegisterRequestDto registerRequestDto
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequestDto, Role.ROLE_CLIENT));
    }

    @Operation(summary = "Register an Restaurant", responses = {
            @ApiResponse(description = "Successfully registered a client",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterRequestDto.class)))
    })
    @PostMapping("/register-Restaurant")
    public ResponseEntity<AuthenticationResponseDto> registerRestaurant(
            @RequestBody RegisterRequestDto registerRequestDto
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequestDto, Role.ROLE_RESTAURANT));
    }

    @Operation(summary = "User login", responses = {
            @ApiResponse(description = "Successfully logged in",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterRequestDto.class)))
    })
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(
            @RequestBody AuthenticationRequestDto loginRequest
    ) {
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }
}