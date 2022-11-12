package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    void removeEtudiant(Long idEtud);

    Etudiant updateEtudiant(Etudiant etudiant);

    List<Etudiant> retreiveAllEtudiants();

    Optional<Etudiant> retrieveEtudiant(Long idEtudiant);

    void addEtudiantContrats(List<Contrat> lc, Long idEtudiant);

}
