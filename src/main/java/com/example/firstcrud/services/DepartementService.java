package com.example.firstcrud.services;

import com.example.firstcrud.entities.Departement;


import com.example.firstcrud.entities.Universite;
import com.example.firstcrud.repositories.IDepartRepository;
import com.example.firstcrud.repositories.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("DepartmentService")

public class DepartementService implements IDepartmentService{


@Autowired
        private IDepartRepository departRepository;

    @Autowired
    private IUniversiteRepository universiteRepository;

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

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){

            Departement departement=departRepository.findById(Long.valueOf(idDepartement)).get();
        Universite universite =universiteRepository.findById(Long.valueOf(idUniversite)).get();

        departement.setUniversite(universite);
        departRepository.save(departement);

    }
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite){
            return departRepository.findByUniversite_IdUniv(idUniversite.longValue());
        }


    }



