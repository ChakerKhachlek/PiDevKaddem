package com.example.firstcrud.services;
import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.services.IDetailEquipeService;
import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.repositories.IDetailEqRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class DetailEquipeService {
    @Service("DetailEquipeService")
    public class DetailEquipeServices implements IDetailEquipeService {

        private IDetailEqRepository detaileqRepository;

        public DetailEquipeServices(IDetailEqRepository deteqRepository) {

            this.detaileqRepository =deteqRepository;
        }
        public DetailEquipe addDeteq(DetailEquipe detailEquipe){

            return detaileqRepository.save(detailEquipe);
        }

        @Override
        public void removeDeteq(Long idDeteq) {
            detaileqRepository.deleteById(idDeteq);

        }



        public DetailEquipe updateDeteq(DetailEquipe detailEquipe)
        {

            return detaileqRepository.save(detailEquipe);
        }

        @Override
        public List<DetailEquipe> retreiveAllDeteq() {
            return detaileqRepository.retreiveAllDeteq();
        }



        @Override
        public Optional<DetailEquipe> retrieveDetEq(Long idDeteq) {
            return detaileqRepository.findById(idDeteq);
        }


    }}
