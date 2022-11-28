package com.example.firstcrud.repositories;
import com.example.firstcrud.entities.Contrat;

import com.example.firstcrud.entities.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {
    @Query("select c from Contrat c where   c.dateDebutContrat>=(?1) and c.dateFinContrat<(?2) and c.archive=false")
    List<Contrat> valideContrats(Date startDate, Date endDate);
}

