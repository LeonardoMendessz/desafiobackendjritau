package com.desafiobackenditau.desafio_back_itau.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                new Info().title("API de  Transações - Desafio Itaú")
                        .description("API para registro e cálculo de estatísticas em tempo real")
                        .version("v1.0")
        );
    }
}
