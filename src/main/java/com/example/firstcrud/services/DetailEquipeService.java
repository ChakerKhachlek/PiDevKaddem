package com.example.firstcrud.services;


import com.example.firstcrud.repositories.IDetailEqRepository;
import org.springframework.stereotype.Service;

public class DetailEquipeService {
    @Service("DetailEquipeService")
    public class DetailEquipe implements IDetailEqRepository {

        private IDetailEqRepository detaileqRepository;

        public DetailEquipe(IDetailEqRepository Idetaileqrepository) {

            this.detaileqRepository =Idetaileqrepository;
        }
        public DetailEquipe addDeteq(DetailEquipe detailEquipe){

            return detaileqRepository.save(detailEquipe);
        }

        public void removeDeteq(Integer idDeteq) {
            detaileqRepository.deleteById(idDeteq);
        }
        public DetailEquipe updateDeteq(DetailEquipe detailEquipe) {

            return detailEquipe.save(detailEquipe);
        }
        public void removeDeteq(Integer iddeteq) {
            detaileqRepository.deleteById(iddeteq);
        }
}
