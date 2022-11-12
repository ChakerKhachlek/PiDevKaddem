package com.example.firstcrud.services;

import com.example.firstcrud.entities.Departement;


import com.example.firstcrud.repositories.IDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("DepartmentService")
public class DepartementService implements IDepartmentService{


@Autowired
        private IDepartRepository departRepository;

        public DepartementService(IDepartRepository DEPRepository) {

            this.departRepository =DEPRepository;
        }


        @Override
        public Departement addDepartement(Departement departement) {
            return departRepository.save(departement);
        }

        public void removeDepart(Long idDepart) {
            departRepository.deleteById(idDepart);
        }

        @Override
        public Departement updateDep(Departement departement) {
            return departRepository.save(departement);
        }

        @Override
        public List<Departement> retreiveAllDep() {
            return departRepository.retreiveDepartments();
        }






        @Override
        public Departement retrieveDepartment(Long id) {
            return departRepository.findById(id).orElse(null);
        }





    }



