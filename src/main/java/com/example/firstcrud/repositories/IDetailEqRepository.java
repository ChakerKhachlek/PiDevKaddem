package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.DetailEquipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDetailEqRepository extends CrudRepository<DetailEquipe,Long> {
    List<DetailEquipe> retreiveAllDeteq();


}
