package com.foodfinder.foodfinderapi.drinks.interfaces;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetAllDrinkQuery;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetDrinkByIdQuery;
import com.foodfinder.foodfinderapi.drinks.domain.services.DrinkCommandService;
import com.foodfinder.foodfinderapi.drinks.domain.services.DrinkQueryService;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.resources.CreateDrinkResource;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.resources.DrinkResource;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.transform.CreateDrinkCommandFromResourceAssembler;
import com.foodfinder.foodfinderapi.drinks.interfaces.rest.transform.DrinkResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/drinks", produces = APPLICATION_JSON_VALUE)
@Tag(name="Drink", description="Drink management EndPoints")
public class DrinkController {
    private final DrinkCommandService drinkCommandService;
    private final DrinkQueryService drinkQueryService;

    public DrinkController(DrinkCommandService drinkCommandService, DrinkQueryService drinkQueryService) {
        this.drinkCommandService = drinkCommandService;
        this.drinkQueryService = drinkQueryService;
    }

    @PostMapping
    public ResponseEntity<DrinkResource>
    createDrink(@RequestBody CreateDrinkResource resource) {
        Optional<Drink> drink = drinkCommandService
                .handle(CreateDrinkCommandFromResourceAssembler
                        .toCommandFromResource(resource));
        return drink.map(source -> new ResponseEntity<>(
                        DrinkResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<DrinkResource> getDrinkById(@PathVariable Long id) {
        Optional<Drink> drink = drinkQueryService
                .handle(new GetDrinkByIdQuery(id));
        return drink.map(source -> ResponseEntity.ok(DrinkResourceFromEntityAssembler
                .toResourceFromEntity(source))).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
