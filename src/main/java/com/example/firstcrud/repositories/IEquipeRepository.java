package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.entities.Niveau;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe,Long> {

    @Override
    List<Equipe> findAll();







}
