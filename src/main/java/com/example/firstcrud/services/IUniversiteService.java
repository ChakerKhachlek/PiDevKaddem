package com.example.firstcrud.services;

import com.example.firstcrud.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {

    Universite addUniversite(Universite univ);
    void removeUniversite(Long idUniv);

    Universite updateUniv(Universite univ);

    List<Universite> retrieveAllUniversites();

    Optional<Universite> retrieveUniversite(Long idUniv);
}
