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
                                .pathsToMatch("/etudiant/**")
                                .pathsToExclude("**")
                                .build();

    }

}
