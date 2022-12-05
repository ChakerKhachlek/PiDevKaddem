package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDetailEqRepository extends CrudRepository<DetailEquipe,Long> {
    @Query(value = "SELECT * FROM DetailsEquipes ",nativeQuery = true)
    List<DetailEquipe> retreiveDetailEquipe();



    DetailEquipe getDetailEquipeByEquipe_IdEquipe(Long id);


}
