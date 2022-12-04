package com.example.firstcrud.controllers;


import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.repositories.IEquipeRepository;
import com.example.firstcrud.services.IDetailEquipeService;
import com.example.firstcrud.services.IEquipeService;
import com.example.firstcrud.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Equipe Management")

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
@CrossOrigin("*")
public class EquipeController {
    IEquipeService equipeService;
    IDetailEquipeService detailEquipeService;


    @Operation(description = "Retreive all equipes")
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
        return listEquipes;
    }
    @Operation(description = "Retreive equipe by id")
    @GetMapping("/retrieve-equipe/{equipe-id}")

    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        return equipeService.retrieveEquipe(Long.valueOf(equipeId));
    }

    @Operation(description = "Add equipe")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody  Equipe e) {
        Equipe equipe= equipeService.addEquipe(e);
        return equipe;
    }

    @Operation(description = "Add equipe and det")
    @PostMapping("/add-equipe-detail")
    public void addEquipe(@RequestBody  Equipe e, DetailEquipe de) {
        detailEquipeService.addDeteq(de);
        Equipe equipe = new Equipe();
        equipe.setDetailEquipe(de);
        equipeService.addEquipe(e);


    }



    @Operation(description = "Update equipe")
    @PutMapping("/update-equipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        Equipe equipe= equipeService.updateEquipe(e);
        return equipe;
    }

    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Long equipeID) {
        equipeService.deleteEquipe(equipeID);
    }

}
