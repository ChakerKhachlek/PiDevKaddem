package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.services.IDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "Departement Management")
@RestController
@AllArgsConstructor
@EnableAutoConfiguration
@RequestMapping("/Departement")
public class DepartementController {
    IDepartmentService departmentService;

    @Operation(description = "Retrieve all departements")
    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartement() {
        List<Departement> listDepartement = departmentService.retreiveAllDep();
        return listDepartement;
    }

    @Operation(description = "Retrieve departement by id")
@GetMapping("/retrieve-departement/{department-id}")
    public Optional<Departement> retrieveDepartement(@PathVariable("department-id") Long departmentId) {
        return Optional.ofNullable(departmentService.retrieveDepartment(departmentId));
    }

    @Operation(description = "Add department")
    @PostMapping("/add-Department")
    public Departement addDepartment(@RequestBody  Departement d) {
        Departement dep=departmentService.addDepartement(d);
        return dep;
    }

    @Operation(description = "Delete department")
    @DeleteMapping("/remove-department/{department-id}")
    public void removeDepartment(@PathVariable("department-id") Long departmentId) {
        departmentService.removeDepart(departmentId);
    }

    @Operation(description = "Update department")
    @PutMapping("/update-department")
    public Departement updateDepartment(@RequestBody Departement d) {
        Departement Dep= departmentService.updateDep(d);
        return Dep;
    }

    @Operation(description = "Assign universite to departement")
    @GetMapping("/assign-universite/{departement-id}/{universite-id}")
    public void asignUniversiteToDepartement(@PathVariable("departement-id") Integer departementId ,@PathVariable("universite-id") Integer universiteId) {
        departmentService.assignUniversiteToDepartement(universiteId, departementId);
    }

    @Operation(description = "Display all universite departemenet")
    @GetMapping("/retreive-universite-departements/{universite-id}")
    public List<Departement> getEtudiantsByDepartement(@PathVariable("universite-id") Integer universiteId ) {
        return  departmentService.retrieveDepartementsByUniversite(universiteId);
    }

}
