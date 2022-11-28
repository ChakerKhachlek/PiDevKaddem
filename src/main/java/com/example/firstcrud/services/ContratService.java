package com.example.firstcrud.services;

import com.example.firstcrud.entities.Contrat;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.entities.Specialite;
import com.example.firstcrud.repositories.IContratRepository;
import com.example.firstcrud.repositories.IEtudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("Contrat Service")
@AllArgsConstructor
public class ContratService implements IContratService{

    private IContratRepository contratRepository;
    private IEtudRepository etudRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(int idContrat) {
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
    public Optional<Contrat> retrieveContrat(int idContrat) {
        return contratRepository.findById(idContrat);
    }

    //Services Avancés


    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudRepository.findByNomELikeIgnoreCaseAndPrenomELikeIgnoreCase(nomE,prenomE).orElse(null);
        Set<Contrat> contrats= etudiant.getContrats();
        int numberOfActiveContrats = 0;
        for(Contrat contrat : contrats){
            if(!contrat.getArchive()){
                numberOfActiveContrats++;
            }
        }
        if(numberOfActiveContrats<5){
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
            return ce;}
        else{
            return null;
        }

    }
    // TODO : To verify when to use the values of (réglement)
    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.valideContrats(startDate,endDate);
        float chiffreAffaire = 0;
        for(Contrat contrat : contrats) {
            chiffreAffaire+=contrat.getMontantContrat();
        }
        return chiffreAffaire;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.valideContrats(startDate,endDate);
        return contrats.size();
    };
}
