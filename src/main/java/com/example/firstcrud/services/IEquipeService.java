package com.example.firstcrud.services;

import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    void addEquipeD(Equipe e, DetailEquipe de);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Long idEquipe);

    Void deleteEquipe (Long idEquipe);


}
