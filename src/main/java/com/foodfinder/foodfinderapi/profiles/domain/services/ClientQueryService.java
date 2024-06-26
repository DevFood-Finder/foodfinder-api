package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllClientsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {
    Optional<Client> handle(GetClientByIdQuery query);
    Optional<Client> handle(GetClientByEmailQuery query);
    List<Client> handle(GetAllClientsQuery query);

}
