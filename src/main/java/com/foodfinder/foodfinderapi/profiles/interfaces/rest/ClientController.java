package com.foodfinder.foodfinderapi.profiles.interfaces.rest;


import com.foodfinder.foodfinderapi.profiles.domain.model.commands.UpdateClientCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetAllClientsQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByEmailQuery;
import com.foodfinder.foodfinderapi.profiles.domain.model.queries.GetClientByIdQuery;
import com.foodfinder.foodfinderapi.profiles.domain.services.ClientCommandService;
import com.foodfinder.foodfinderapi.profiles.domain.services.ClientQueryService;
import com.foodfinder.foodfinderapi.profiles.interfaces.rest.dto.UpdateClientProfileDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Client", description = "Client information")
@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientQueryService clientQueryService;
    private final ClientCommandService clientCommandService;

    @Operation(summary = "Get all clients", responses = {
            @ApiResponse(description = "Client status",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)))
    })
    @GetMapping()
    public Iterable<Client> getAll() {
        var getAllClientsQuery = new GetAllClientsQuery();
        return clientQueryService.handle(getAllClientsQuery);
    }

    @Operation(summary = "Get client by id", responses = {
            @ApiResponse(description = "Client status",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        var getClientByIdQuery = new GetClientByIdQuery(id);
        return clientQueryService.handle(getClientByIdQuery);
    }

    @Operation(summary = "Get client by email", responses = {
            @ApiResponse(description = "Client status",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)))
    })
    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable String email) {
        var getClientByEmailQuery = new GetClientByEmailQuery(email);
        return clientQueryService.handle(getClientByEmailQuery).orElse(null);
    }

    @Operation(summary = "Update client profile", responses = {
            @ApiResponse(description = "Client status",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)))
    })
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody UpdateClientProfileDto updatedClient) {
        var updateClientCommand = new UpdateClientCommand(id, updatedClient);
        return clientCommandService.handle(updateClientCommand);
    }


}
