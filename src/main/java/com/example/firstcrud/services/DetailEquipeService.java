package com.example.firstcrud.services;

import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.repositories.IDetailEqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DetailEquipeService implements IDetailEquipeService {
@Autowired
  IDetailEqRepository DetailEqRepository;


    @Override
    public DetailEquipe addDeteq(DetailEquipe detailEquipe) {
        return DetailEqRepository.save(detailEquipe);
    }

    @Override
    public void removeDeteq(Long idDeteq) {
        DetailEqRepository.deleteById(idDeteq);

    }

    @Override
    public DetailEquipe updateDeteq(DetailEquipe detailEquipe) {
        return DetailEqRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> retreiveAllDeteq() {
        return DetailEqRepository.retreiveDetailEquipe();
    }

    @Override
    public Optional<DetailEquipe> retrieveDetEq(Long idDeteq) {
        return Optional.empty();
    }
}
