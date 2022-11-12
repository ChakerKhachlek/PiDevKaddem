package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;

import javax.persistence.Id;
import java.util.Optional;

public interface IContratService {
    Contrat addContrat(Contrat contrat);

    void removeContrat(Id idContrat);

    Contrat updateContrat(Contrat contrat);

    Iterable<Contrat> retreiveAllContrats();

    Optional<Contrat> retrieveContrat(Id idContrat);

}
