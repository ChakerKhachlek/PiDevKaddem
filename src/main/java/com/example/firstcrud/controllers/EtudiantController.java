package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.services.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Etudiant Management")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;

    @Operation(description = "Retrieve all etudiants")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEquipes = etudiantService.retreiveAllEtudiants();
        return listEquipes;
    }

    @Operation(description = "Add contracts to etudiant")
    @PostMapping("/add-contrats/{id-etudiant}")
    public void ajouterEtaffecterListeContrats(@RequestBody List<Contrat> lc, @PathVariable("id-etudiant") Long idEtudiant){
        etudiantService.addEtudiantContrats(lc, idEtudiant);
    }

    @Operation(description = "Retreive etudiant by ID")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Optional<Etudiant> retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    @Operation(description = "Add etudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody  Etudiant e) {

        Etudiant etud=etudiantService.addEtudiant(e);
        return etud;
    }


    @Operation(description = "Update etudiant")
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant equipe= etudiantService.updateEtudiant(e);
        return equipe;
    }
    
    @Operation(description = "Remove etudiant")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantID) {
        etudiantService.removeEtudiant(etudiantID);
    }

}
