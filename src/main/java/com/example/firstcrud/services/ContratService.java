package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.repositories.IContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service("ContratService")
public class ContratService implements IContratService{

    @Autowired
    IContratRepository contratRepository;
    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override

    public void removeContrat(Long idContrat) {

       contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retreiveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override

    public Optional<Contrat> retrieveContrat(Long idContrat) {


       return contratRepository.findById(idContrat);
    }
}
