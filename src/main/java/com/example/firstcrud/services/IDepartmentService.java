package com.example.firstcrud.services;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.DetailEquipe;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    Departement addDepartement(Departement departement);

    void removeDepart(Integer idDepartment);

    Departement updateDep(Departement departement);

    List<Departement> retreiveAllDep();

    Optional<Departement> retrieveDepartment(Integer id);

}
