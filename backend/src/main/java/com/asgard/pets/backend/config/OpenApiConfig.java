package com.asgard.pets.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI asgardPetsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Asgard Pets")
                        .description("Asgard Pets: distribuidora de alimento, medicina y accesorios para mascotas, que sostiene la fundación Aurora. Módulos documentados aquí: Usuario y Producto.")
                        .version("v1.0"));
    }
}