package com.foodfinder.foodfinderapi.security.api;

import com.foodfinder.foodfinderapi.security.domain.model.entity.User;
import com.foodfinder.foodfinderapi.security.service.UserService;
import com.foodfinder.foodfinderapi.security.service.dto.UpdateUserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "User", description = "User edit, delete, and view user information")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get all users", responses = {
            @ApiResponse(description = "All users found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)))
    })
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get user by id", responses = {
            @ApiResponse(description = "User found",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)))
    })
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Update user information", responses = {
            @ApiResponse(description = "User found and updated",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)))
    })
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDto updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @Operation(summary = "Delete user", responses = {
            @ApiResponse(description = "User found and deleted",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)))
    })
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
