package com.example.firstcrud.services;

import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.repositories.IDepartRepository;
import com.example.firstcrud.repositories.IDetailEqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.AssociationOverrides;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DetailEquipeServices implements IDetailEquipeService {

 private  final    IDetailEqRepository iDetailEqRepository;


    @Override
    public DetailEquipe addDeteq(DetailEquipe detailEquipe) {
        return iDetailEqRepository.save(detailEquipe);
    }

    @Override
    public void removeDeteq(Long idDeteq) {
        iDetailEqRepository.deleteById(idDeteq);

    }

    @Override
    public DetailEquipe updateDeteq(DetailEquipe detailEquipe) {
        return iDetailEqRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> retreiveAllDeteq() {
        return iDetailEqRepository.findAll();
    }

    @Override
    public Optional<DetailEquipe> retrieveDetEq(Long idDeteq) {
        return Optional.empty();
    }
}
