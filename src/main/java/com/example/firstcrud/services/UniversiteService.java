package com.example.firstcrud.services;

import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.repositories.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("UniversiteService")
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
    public void deleteUniversiteByID(Long idUniv) {
        univRepository.deleteById(idUniv);
    }

    @Override
    public Universite updateUniv(Universite univ) {
        return univRepository.save(univ);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return (List<Universite>) univRepository.findAll();
    }

    @Override
    public Optional<Universite> getUniversiteByID(Long idUniv) {
        return univRepository.findById(idUniv);
    }
}
