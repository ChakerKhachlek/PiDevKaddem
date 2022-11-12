package com.example.firstcrud.services;

import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IDetailEquipeService {
    DetailEquipe addDeteq(DetailEquipe detailEquipe);

    void removeDeteq(Long idDeteq);

    DetailEquipe updateDeteq(DetailEquipe detailEquipe);

    List<DetailEquipe> retreiveAllDeteq();

    Optional<DetailEquipe> retrieveDetEq(Long idDeteq);

}
