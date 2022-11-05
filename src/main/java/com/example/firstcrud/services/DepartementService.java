package com.example.firstcrud.services;

import com.example.firstcrud.entities.Departement;

import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.repositories.IDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class DepartementService {


    @Service("DepartmentService")
    public class DepartmentService implements IDepartmentService{

        private IDepartRepository departRepository;

        public DepartmentService(IDepartRepository DEPRepository) {

            this.departRepository =DEPRepository;
        }
        public Departement addDep(Departement departement){

            return departRepository.save(departement);
        }
        public void removeDepart(Integer idDepart) {
            departRepository.deleteById(idDepart);
        }
        public Departement updateDepart(Departement departement) {

            return departRepository.save(departement);
        }
        public void removeDepartement(Integer idDep) {
            departRepository.deleteById(idDep);
        }













    }


}
