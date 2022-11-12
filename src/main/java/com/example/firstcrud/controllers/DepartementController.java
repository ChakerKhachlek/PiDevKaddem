package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.services.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Departement")
public class DepartementController {
    IDepartmentService departmentService;

    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartement() {
        List<Departement> listDepartement = departmentService.retreiveAllDep();
        return listDepartement;
    }

@GetMapping("/retrieve-departement/{department-id}")
    public Optional<Departement> retrieveDepartement(@PathVariable("department-id") Integer departmentId) {
        return Optional.ofNullable(departmentService.retrieveDepartment(departmentId));
    }
    @PostMapping("/add-Department")
    public Departement addDepartment(@RequestBody  Departement d) {
        Departement dep=departmentService.addDepartement(d);
        return dep;
    }

    @DeleteMapping("/remove-department/{department-id}")
    public void removeDepartment(@PathVariable("department-id") Integer departmentId) {
        departmentService.removeDepart(departmentId);
    }

    @PutMapping("/update-department")
    public Departement updateDepartment(@RequestBody Departement d) {
        Departement Dep= departmentService.updateDep(d);
        return Dep;
    }
}
