package com.example.firstcrud.controllers;


import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Universite Management")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService universiteService;

    @Operation(description = "Add universite")

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {

        Universite universite=universiteService.addUniversite(u);
        return universite;
    }

}
