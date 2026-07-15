package com.example.leadmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI leadManagementOpenAPI() {

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()

                .info(
                        new Info()
                                .title("Lead Management System API")
                                .version("1.0.0")
                                .description("REST API for Lead Management using Spring Boot and JWT Authentication")
                                .contact(
                                        new Contact()
                                                .name("Umme")
                                                .email("your-email@example.com")
                                )
                )

                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName)
                )

                .schemaRequirement(
                        securitySchemeName,
                        new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                );
    }
}