package com.example.firstcrud.controllers;


import com.example.firstcrud.entities.Universite;

import com.example.firstcrud.repositories.IUniversiteRepository;
import com.example.firstcrud.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Universite Management")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService univService;
    IUniversiteRepository univRepository;

    @Operation(description = "Add universite")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {

        Universite universite = univService.addUniversite(u);
        return universite;
    }

    @Operation(description = "Get all universites")
    @GetMapping("/get-all-universites")
    public List<Universite> getAllUniversites() {
        List<Universite> listUniversites = univService.getAllUniversites();
        return listUniversites;
    }

    @Operation(description = "Get universite by ID")
    @GetMapping("/get-universite/{universite-id}")
    public Optional<Universite> getUniversiteByID(@PathVariable("universite-id") Long univID) {
        return univService.getUniversiteByID(univID);
    }

    @Operation(description = "Update universite")
    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        Universite universite = univService.updateUniv(e);
        return universite;
    }
    @Operation(description = "Delete universite By ID")
    @DeleteMapping("/delete-universite/{universite-id}")
    public void deleteUniversiteByID(@PathVariable("universite-id") Long idUniv) {
        univService.deleteUniversiteByID(idUniv);
    }

}
