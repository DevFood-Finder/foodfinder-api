package com.foodfinder.foodfinderapi.drinks.application.internal.queryservices;

import com.foodfinder.foodfinderapi.drinks.domain.model.aggregates.Drink;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetAllDrinkQuery;
import com.foodfinder.foodfinderapi.drinks.domain.model.queries.GetDrinkByIdQuery;
import com.foodfinder.foodfinderapi.drinks.domain.services.DrinkQueryService;
import com.foodfinder.foodfinderapi.drinks.infrastrcuture.persitence.jpa.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkQueryServiceImpl implements DrinkQueryService {
    private final DrinkRepository drinkRepository;

    public DrinkQueryServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Optional<Drink> handle(GetDrinkByIdQuery query) {
        return drinkRepository.findById(query.id());
    }

    @Override
    public List<Drink> handle(GetAllDrinkQuery query) {
        return drinkRepository.findAll();
    }
}
