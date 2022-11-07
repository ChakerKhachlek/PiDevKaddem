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
@Autowired
        private IDepartRepository departRepository;

        public DepartmentService(IDepartRepository DEPRepository) {

            this.departRepository =DEPRepository;
        }


        @Override
        public Departement addDepartement(Departement departement) {
            return departRepository.save(departement);
        }

        public void removeDepart(Integer idDepart) {
            departRepository.deleteById(idDepart);
        }

        @Override
        public Departement updateDep(Departement departement) {
            return departRepository.save(departement);
        }

        @Override
        public List<Departement> retreiveAllDep() {
            return departRepository.retreiveAllDep();
        }






        @Override
        public Optional<Departement> retrieveDepartment(Integer id) {
            return departRepository.findById(id);
        }

        public void removeDepartement(Integer idDep) {
            departRepository.deleteById(idDep);
        }

    }


}
