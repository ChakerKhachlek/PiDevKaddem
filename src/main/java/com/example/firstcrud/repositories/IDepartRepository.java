package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDepartRepository extends JpaRepository<Departement,Integer> {


}
