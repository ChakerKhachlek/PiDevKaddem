package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.entities.Specialite;
import com.example.firstcrud.repositories.IContratRepository;
import com.example.firstcrud.repositories.IEtudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("ContratService")
public class ContratService implements IContratService{

    @Autowired
    IContratRepository contratRepository;

    @Autowired
    IEtudRepository etudRepository;
    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override

    public void removeContrat(Long idContrat) {

       contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retreiveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override

    public Optional<Contrat> retrieveContrat(Long idContrat) {


       return contratRepository.findById(idContrat);
    }



    @Override
    public Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE){
        Etudiant e=etudRepository.findByNomELikeIgnoreCaseAndPrenomELikeIgnoreCase(nomE,prenomE).get();
        if(e.getContrats().size()>5){
            return null;
        }else{
            ce.setEtudiant(e);
            return contratRepository.save(ce);
        }



    };

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contratRepository.valideContratsBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getArchive()==false){
                if(c.getSpecialite().equals(Specialite.IA)){
                    chiffre=chiffre+300;
                }
                else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                    chiffre=chiffre+350;
                }
                else if(c.getSpecialite().equals(Specialite.CLOUD)){
                    chiffre=chiffre+400;
                }
                else if (c.getSpecialite().equals(Specialite.SECURITE)){
                    chiffre=chiffre+450;
                }
            }

        }
        return chiffre;
    }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contratRepository.valideContratsBetween2dates(startDate,endDate);
    }
}
