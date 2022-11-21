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
        List<Etudiant> listEtudiants = etudiantService.retreiveAllEtudiants();
        return listEtudiants;
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
        System.out.println(e);
        Etudiant etud=etudiantService.addEtudiant(e);
        return etud;
    }


    @Operation(description = "Update etudiant")
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= etudiantService.updateEtudiant(e);
        return etudiant;
    }
    @Operation(description = "Assign departement to etudiant")
    @GetMapping("/assign-departement/{etudiant-id}/{departement-id}")
    public void asignDepartementToEtudiant(@PathVariable("etudiant-id") Integer etudiantId ,@PathVariable("departement-id") Integer departmentId) {
       etudiantService.assignEtudiantToDepartement(etudiantId, departmentId);
    }
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantID) {
        etudiantService.removeEtudiant(etudiantID);
    }

    @Operation(description = "Add and assign etudiant to equipe and contrat")
    @PostMapping("/add-assign-equipe-contrat/{equipe-id}/{contrat-id}")
    public void addAndAssignEtudiantToEquipeAndContract(@PathVariable("equipe-id") Integer equipeId ,@PathVariable("contrat-id") Integer contratId,@RequestBody  Etudiant e) {
        etudiantService.addAndAssignEtudiantToEquipeAndContract(e,contratId,equipeId);
    }


    @Operation(description = "Display all departement etudiants")
    @GetMapping("/retreive-departement-etudiants/{departement-id}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("departement-id") Integer departementId ) {
        return  etudiantService.getEtudiantsByDepartement(departementId);
    }

}
