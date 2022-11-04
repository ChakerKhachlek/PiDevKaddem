package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEquipes = etudiantService.retreiveAllEtudiants();
        return listEquipes;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Optional<Etudiant> retrieveEquipe(@PathVariable("etudiant-id") Integer etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }


    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody  Etudiant e) {
        Etudiant etud=etudiantService.addEtudiant(e);
        return etud;
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantID) {
        etudiantService.removeEtudiant(etudiantID);
    }

    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant equipe= etudiantService.updateEtudiant(e);
        return equipe;
    }
}
