package com.example.firstcrud.repositories;
import com.example.firstcrud.entities.Contrat;

import com.example.firstcrud.entities.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContratRepository extends CrudRepository<Contrat,Integer> {


}
