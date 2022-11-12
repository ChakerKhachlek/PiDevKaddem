package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface IContratService {
    Contrat addContrat(Contrat contrat);


    void removeContrat(Long idContrat);


    Contrat updateContrat(Contrat contrat);

    List<Contrat> retreiveAllContrats();


    Optional<Contrat> retrieveContrat(Long idContrat);


}
