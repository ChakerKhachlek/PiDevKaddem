package com.example.firstcrud.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springKaddemOpenApi(){
        return new OpenAPI().info(infoApi());
    }

    public Info infoApi(){
        return new Info().title("Spring Documentation")
                .description("Etude de cas Kaddem")
                .contact(contactApi());
    }

    public Contact contactApi(){
        Contact contact=new Contact().name("Our team")
                .email("chaker.khachlek@esprit.tn")
                .url("https://github.com/ChakerKhachlek/PiDevKaddem/tree/master");
        return contact;
    }

    @Bean
    public GroupedOpenApi etudiantPublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Etudiant Management API")
                                .pathsToMatch("/api/etudiant/**")
                                .pathsToExclude("**")
                                .build();

    }

    @Bean
    public GroupedOpenApi contratPublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Contrat Management API")
                .pathsToMatch("/contrat/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi departementPublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Departement Management API")
                .pathsToMatch("/Departement/**")
                .pathsToExclude("**")
                .build();

    }

    @Bean
    public GroupedOpenApi universitePublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Universite Management API")
                .pathsToMatch("/universite/**")
                .pathsToExclude("**")
                .build();

    }
    @Bean
    public GroupedOpenApi quipePublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Equipe Management API")
                .pathsToMatch("/equipe/**")
                .pathsToExclude("**")
                .build();

    }
}
