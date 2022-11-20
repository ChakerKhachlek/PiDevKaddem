package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IDepartRepository extends CrudRepository<Departement,Long> {
    @Query(value = "SELECT * FROM DEPARTMENTS ",nativeQuery = true)
    List<Departement> retreiveDepartments();

    @Query("select d from Departement d where d.universite.idUniv = ?1")
    List<Departement> findByUniversite_IdUniv(Long idUniv);




}