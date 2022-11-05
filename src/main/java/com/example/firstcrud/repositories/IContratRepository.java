package com.example.firstcrud.repositories;
import com.example.firstcrud.entities.Contrat;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface IContratRepository extends CrudRepository<Contrat, Id> {
}
