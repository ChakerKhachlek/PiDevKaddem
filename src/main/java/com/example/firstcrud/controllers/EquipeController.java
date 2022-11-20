package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.repositories.IEquipeRepository;
import com.example.firstcrud.services.IEquipeService;
import com.example.firstcrud.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Equipe Management")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    IEquipeService equipeService;

    @Operation(description = "Add equipe")

    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe e) {

        Equipe universite=equipeService.addEquipe(e);
        return universite;
    }

}
