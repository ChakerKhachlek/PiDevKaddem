package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Equipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe,Integer> {

    @Override
    List<Equipe> findAll();
}
