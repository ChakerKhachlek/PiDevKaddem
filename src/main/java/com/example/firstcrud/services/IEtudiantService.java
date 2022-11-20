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

    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe);

    void addEtudiantContrats(List<Contrat> lc, Long idEtudiant);

    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);


}
