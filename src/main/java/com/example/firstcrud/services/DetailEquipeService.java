package com.example.firstcrud.services;
import com.example.firstcrud.services.IDetailEquipeService;
import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.repositories.IDetailEqRepository;
import org.springframework.stereotype.Service;

public class DetailEquipeService {
    @Service("DetailEquipeService")
    public class DetailEquipeService implements IDetailEquipeService {

        private IDetailEqRepository detaileqRepository;

        public DetailEquipeService(IDetailEqRepository Idetaileqrepository) {

            this.detaileqRepository =Idetaileqrepository;
        }
        public DetailEquipe addDeteq(DetailEquipe detailEquipe){

            return detaileqRepository.save(detailEquipe);
        }

        public void removeDeteq(Long idDeteq) {
            detaileqRepository.deleteById(idDeteq);
        }
        public DetailEquipe updateDeteq(DetailEquipe detailEquipe) {

            return detaileqRepository.save(detailEquipe);
        }

}}
