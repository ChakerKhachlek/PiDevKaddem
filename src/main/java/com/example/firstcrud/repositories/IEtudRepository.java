package com.example.firstcrud.repositories;

import com.example.firstcrud.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEtudRepository extends CrudRepository<Etudiant,Long> {

    @Query("select e from Etudiant e where upper(e.prenomE) like upper(?1)")
    List<Etudiant> findByPrenomELikeIgnoreCase(@Nullable String prenomE);

    @Query(
            value = "SELECT * FROM ETUDIANTS ",
            nativeQuery = true)
    List<Etudiant> retreiveAllEtudiants();

    @Query("select e from Etudiant e where upper(e.nomE) like upper(?1) and upper(e.prenomE) like upper(?2)")
    Optional<Etudiant> findByNomELikeIgnoreCaseAndPrenomELikeIgnoreCase(String nomE, String prenomE);

    @Query("select e from Etudiant e where e.departement.idDepart = ?1")
    List<Etudiant> findByDepartement_IdDepart(Long idDepart);






}
