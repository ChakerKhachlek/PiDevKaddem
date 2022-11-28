package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IContratService {
    Contrat addContrat(Contrat contrat);

    void removeContrat(int idContrat);

    Contrat updateContrat(Contrat contrat);

    List<Contrat> retreiveAllContrats();

    Optional<Contrat> retrieveContrat(int idContrat);

    //Services Avancés

    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    Integer nbContratsValides(Date startDate, Date endDate);

}
