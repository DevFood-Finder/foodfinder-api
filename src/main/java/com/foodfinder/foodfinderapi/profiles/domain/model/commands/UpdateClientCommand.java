package com.foodfinder.foodfinderapi.profiles.domain.model.commands;

import com.foodfinder.foodfinderapi.profiles.interfaces.rest.dto.UpdateClientProfileDto;

public record UpdateClientCommand(Long id, UpdateClientProfileDto updatedClient) {
}
