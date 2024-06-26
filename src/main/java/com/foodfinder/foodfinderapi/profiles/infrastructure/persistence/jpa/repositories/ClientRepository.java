package com.foodfinder.foodfinderapi.profiles.infrastructure.persistence.jpa.repositories;

import com.foodfinder.foodfinderapi.profiles.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByEmail(String email);
    List<Client> findAll();
}
