package com.example.firstcrud.services;

import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.repositories.IEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("EquipeService")
public class EquipeService implements IEquipeService{

    @Autowired
    private IEquipeRepository iEquipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> lstEquipe = new ArrayList<>();
        lstEquipe.addAll(iEquipeRepository.findAll());
        return lstEquipe;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return iEquipeRepository.findById(idEquipe).get();
    }

    @Override
    public Void deleteEquipe(Long idEquipe) {

         iEquipeRepository.deleteById(idEquipe);
        return null;
    }


}
