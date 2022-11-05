package com.example.firstcrud.services;

import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.repositories.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UniversiteService implements IUniversiteService {

    @Autowired
    private IUniversiteRepository univRepository;

    public UniversiteService(IUniversiteRepository univRepository){
        this.univRepository = univRepository;
    }

    @Override
    public Universite addUniversite(Universite univ) {
        return univRepository.save(univ);
    }

    @Override
    public void removeUniversite(Long idUniv) {
        univRepository.deleteById(idUniv);
    }

    @Override
    public Universite updateUniv(Universite univ) {
        return univRepository.save(univ);
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        return univRepository.retrieveAllUniversites();
    }

    @Override
    public Optional<Universite> retrieveUniversite(Long idUniv) {
        return univRepository.findById(idUniv);
    }
}
