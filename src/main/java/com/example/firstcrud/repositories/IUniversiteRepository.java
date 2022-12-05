package com.example.firstcrud.repositories;


import com.example.firstcrud.entities.Universite;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface IUniversiteRepository extends CrudRepository<Universite,Long> {


}
