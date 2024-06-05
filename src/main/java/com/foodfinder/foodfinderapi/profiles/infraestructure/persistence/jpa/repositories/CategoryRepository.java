package com.foodfinder.foodfinderapi.profiles.infraestructure.persistence.jpa.repositories;

import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}