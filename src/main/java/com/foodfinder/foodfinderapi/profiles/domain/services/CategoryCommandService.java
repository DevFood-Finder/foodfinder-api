package com.foodfinder.foodfinderapi.profiles.domain.services;

import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.Categories;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateCategoryCommand;

import java.util.Optional;

public interface CategoryCommandService {
    Optional<Categories> handle(CreateCategoryCommand command);
}
