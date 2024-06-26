package com.foodfinder.foodfinderapi.shared.infrastructure.documentation.openapi.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI foodFinderOpenApi() {
        // General configuration
        var openAPI = new OpenAPI();
        openAPI
                .info(new Info()
                .title("FoodFinder API")
                .description("FoodFinder application REST API documentation.")
                .version("v1.0.0")
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("FoodFinder wiki Documentation")
                        .url("https://food-finder.wiki.github.io/docs"));


        return openAPI;

    }
}
