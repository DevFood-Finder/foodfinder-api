package com.foodfinder.foodfinderapi.profiles.application.internal.commandservices;

import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.Categories;
import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateCategoryCommand;
import com.foodfinder.foodfinderapi.profiles.domain.services.CategoryCommandService;
import com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoriesRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Optional<Categories> handle(CreateCategoryCommand command) {
        var category = new Categories(command.name());
        categoriesRepository.save(category);
        return Optional.of(category);
    }
}