package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import org.springframework.data.repository.CrudRepository;

public interface IDepartRepository extends CrudRepository<Departement,Integer> {
}
