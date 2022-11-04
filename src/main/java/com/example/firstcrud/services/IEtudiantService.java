package com.example.firstcrud.services;

import com.example.firstcrud.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    void removeEtudiant(Integer idEtud);

    Etudiant updateEtudiant(Etudiant etudiant);

    List<Etudiant> retreiveAllEtudiants();

    Optional<Etudiant> retrieveEtudiant(Integer idEtudiant);

}
