package com.foodfinder.foodfinderapi.review.infrastructure.persistence.jpa.repositories;

import com.foodfinder.foodfinderapi.review.domain.model.aggregates.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByQualification(Integer qualification);

    boolean existsByDescriptionAndQualification(String description, Integer qualification);


}
