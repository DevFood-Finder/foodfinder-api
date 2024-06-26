package com.foodfinder.foodfinderapi.profiles.application.internal.queryservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllClientsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.ClientQueryService;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    public ClientQueryServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.id());
    }

    @Override
    public Optional<Client> handle(GetClientByEmailQuery query) {
        return clientRepository.findByEmail(query.Email());
    }

    @Override
    public List<Client> handle(GetAllClientsQuery query) {
        return clientRepository.findAll();
    }
}
