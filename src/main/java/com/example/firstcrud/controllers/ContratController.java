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
@Tag(name = "Contract Management")
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
    public Optional<Contrat> getContratById(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId);
    }




    @PostMapping("/add-contrat")
    public Contrat addcontrat(@RequestBody  Contrat c) {
        Contrat contrat=contratService.addContrat(c);
        return contrat;
    }

    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removecontrat(@PathVariable("contrat-id") Long contratID) {
        contratService.removeContrat(contratID);
    }

    @PutMapping("/update-contrat")
    public Contrat updatecontrat(@RequestBody Contrat c) {
        Contrat contrat= contratService.updateContrat(c);
        return contrat;
    }



    @Operation(description = "Affect Contrat Etudiant")
    @PostMapping("/affect-contrat-etudiant/{nom-e}/{prenom-e}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat c,@PathVariable("nom-e") String nomE,@PathVariable("prenom-e") String prenomE){
        return contratService.affectContratToEtudiant(c,nomE,prenomE);
    }
    @Operation(description = "Get chiffre affaire entre deux dates")
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contratService.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @Operation(description = "Contrats between 2 dates")
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contratService.contratBetween2dates(start,end);
    }
}

