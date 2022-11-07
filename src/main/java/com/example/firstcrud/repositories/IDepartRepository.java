package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDepartRepository extends CrudRepository<Departement,Integer> {

    List<Departement> retreiveAllDep();

}
