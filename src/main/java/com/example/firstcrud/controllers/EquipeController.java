package com.example.firstcrud.controllers;


import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.services.EquipeService;
import com.example.firstcrud.services.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
