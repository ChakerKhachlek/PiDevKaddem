package com.example.firstcrud.services;

import com.example.firstcrud.entities.*;
import com.example.firstcrud.repositories.IDetailEqRepository;
import com.example.firstcrud.repositories.IEquipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("EquipeService")
public class EquipeService implements IEquipeService{

    @Autowired
    private IEquipeRepository iEquipeRepository;

    @Autowired
    private IDetailEqRepository iDetailEqRepository;

    Logger log= LoggerFactory.getLogger(EquipeService.class);
    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> lstEquipe = new ArrayList<>();
        lstEquipe.addAll(iEquipeRepository.findAll());
        return lstEquipe;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public void addEquipeD(Equipe e, DetailEquipe de) {
        e.setDetailEquipe(de);
        iDetailEqRepository.save(de);
        iEquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return iEquipeRepository.findById(idEquipe).get();
    }

    @Override
    public Void deleteEquipe(Long idEquipe) {

         iEquipeRepository.deleteById(idEquipe);
        return null;
    }


    public Boolean isStudentContractMoreThanOneYear(Etudiant etudiant){
        // comparer la date début du contract avec la date actuelle
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date today1 = new Date();

        for (Contrat contrat : etudiant.getContrats()) {
            long debCont = contrat.getDateFinContrat().getTime();
            long timeDiff = Math.abs(debCont - today1.getTime());
            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
            if(daysDiff >= 365){
                return true;
            }
        }
        return false;
    }

    @Scheduled(cron = "0 0 13 * * *")
    public void faireEvoluerEquipes(){
        // Todo page 22
        List<Equipe> equipes = retrieveAllEquipes();

        for (Equipe equipe : equipes) {
            if(equipe.getEtudiants().size() >= 3 && (equipe.getNiveau() == Niveau.JUNIOR || equipe.getNiveau() == Niveau.SENIOR) ){
                if(equipe.getEtudiants().stream().allMatch(this::isStudentContractMoreThanOneYear))
                {
                    log.info("l'equipes a 3 membres ou plus ayant dépassé 1 an avec contrat");
                    if(equipe.getNiveau() == Niveau.JUNIOR){
                        equipe.setNiveau(Niveau.SENIOR);
                    } else if (equipe.getNiveau()== Niveau.SENIOR) {
                        equipe.setNiveau(Niveau.EXPERT);
                    }
                }
            }else {
                log.info("l'equipe"+equipe.getNomEquipe()+" ne respecte pas la condition");
            }
        }

    }


}
