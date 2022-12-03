package com.example.firstcrud.services;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    Departement addDepartement(Departement departement);

    void removeDepart(Long idDepartment);

    Departement updateDep(Departement departement);

    List<Departement> retreiveAllDep();

    Departement retrieveDepartment(Long id);

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
