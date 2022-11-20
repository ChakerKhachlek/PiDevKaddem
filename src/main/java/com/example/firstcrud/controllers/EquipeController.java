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

 
    
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
        return listEquipes;
    }

    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        return equipeService.retrieveEquipe(equipeId);
    }

    @Operation(description = "Add equipe")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody  Equipe e) {
        Equipe equipe= equipeService.addEquipe(e);
        return equipe;
    }
    

    @PutMapping("/update-equipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        Equipe equipe= equipeService.updateEquipe(e);
        return equipe;
    }

}
