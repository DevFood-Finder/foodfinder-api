package com.foodfinder.foodfinderapi.client.domain.service;

import com.foodfinder.foodfinderapi.client.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.client.infrastructure.persistence.jpa.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id
        ).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }


}
