package com.foodfinder.foodfinderapi.security.domain.persistence;

import com.foodfinder.foodfinderapi.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
