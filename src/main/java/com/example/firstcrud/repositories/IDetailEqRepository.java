package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDetailEqRepository extends JpaRepository<DetailEquipe,Long> {


}
