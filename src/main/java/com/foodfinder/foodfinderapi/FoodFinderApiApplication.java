package com.foodfinder.foodfinderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FoodFinderApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodFinderApiApplication.class, args);
    }

}
