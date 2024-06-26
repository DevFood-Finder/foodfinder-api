package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateClientCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;

public interface ClientCommandService {
    Client handle(UpdateClientCommand command);
}
