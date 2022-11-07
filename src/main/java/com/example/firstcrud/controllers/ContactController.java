package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContactController {
    @Autowired
    IContratService contratService;

    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getcontrats() {
        List<Contrat> listContrats = contratService.retreiveAllContrats();
        return listContrats;
    }

    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Optional<Contrat> retrieveContrat(@PathVariable("contrat-id") Integer contratId) {
        return contratService.retrieveContrat(contratId);
    }


    @PostMapping("/add-contrat")
    public Contrat addcontrat(@RequestBody  Contrat c) {
        Contrat contrat=contratService.addContrat(c);
        return contrat;
    }

    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removecontrat(@PathVariable("contrat-id") Integer contratID) {
        contratService.retrieveContrat(contratID);
    }

    @PutMapping("/update-contrat")
    public Contrat updatecontrat(@RequestBody Contrat c) {
        Contrat contrat= contratService.updateContrat(c);
        return contrat;
    }
}

