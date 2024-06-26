package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateClientCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.profiles.domain.services.ClientCommandService;
import com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    private final ClientRepository clientRepository;

    public ClientCommandServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client handle(UpdateClientCommand command) {
        return clientRepository.findById(command.id())
                .map(client -> {
                    client.setNickName(command.updatedClient().getNickName());

                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
