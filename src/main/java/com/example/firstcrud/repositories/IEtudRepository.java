package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudRepository extends CrudRepository<Etudiant,Integer> {



}
