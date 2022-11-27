package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.services.IContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Tag(name="Gestion Contrat")
@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService contratService;

    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getcontrats() {
        List<Contrat> listContrats = contratService.retreiveAllContrats();
        return listContrats;
    }

    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Optional<Contrat> getContratById(@PathVariable("contrat-id") Integer contratId) {
        return contratService.retrieveContrat(contratId);
    }


    @PostMapping("/add-contrat")
    public Contrat addcontrat(@RequestBody  Contrat c) {
        Contrat contrat=contratService.addContrat(c);
        return contrat;
    }

    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removecontrat(@PathVariable("contrat-id") Integer contratID) {
        contratService.removeContrat(contratID);
    }

    @PutMapping("/update-contrat")
    public Contrat updatecontrat(@RequestBody Contrat c) {
        Contrat contrat= contratService.updateContrat(c);
        return contrat;
    }
    //Services Avancés
    @PostMapping("/affect-contrat-etudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat c,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE){
        return contratService.affectContratToEtudiant(c,nomE,prenomE);
    }
    @GetMapping("/ChiffreAffaire-EntreDeuxDate/{startDate}/{endDate}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date endDate){
        return contratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
    @GetMapping("/nb-contrats-valides/{startDate}/{endDate}")
    Integer nbContratsValides(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date endDate){
        return contratService.nbContratsValides(startDate,endDate);
    }

}

