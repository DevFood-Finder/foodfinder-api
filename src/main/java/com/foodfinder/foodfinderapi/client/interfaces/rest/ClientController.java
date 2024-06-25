package com.foodfinder.foodfinderapi.client.interfaces.rest;


import com.foodfinder.foodfinderapi.client.domain.model.entity.Client;
import com.foodfinder.foodfinderapi.client.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Client", description = "Client information")
@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Get all clients", responses = {
            @ApiResponse(description = "Client status",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)))
    })
    @GetMapping()
    public Iterable<Client> getAll() {
        return clientService.getAllClients();
    }


    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
    }

}
