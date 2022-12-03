package com.example.firstcrud.services;
import com.example.firstcrud.entities.Contrat;

import com.example.firstcrud.entities.Departement;
import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.repositories.IContratRepository;
import com.example.firstcrud.repositories.IDepartRepository;
import com.example.firstcrud.repositories.IEquipeRepository;

import com.example.firstcrud.repositories.IEtudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EtudiantService")
public class EtudiantService implements IEtudiantService{

    @Autowired
    private IEtudRepository etudRepository;

    @Autowired
    private IContratRepository contratRepository;

    @Autowired
    private IDepartRepository depRepository;

    @Autowired
    private IEquipeRepository equipeRepository;
    

    public EtudiantService(IEtudRepository etudRepository) {
        this.etudRepository = etudRepository;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant){
        return etudRepository.save(etudiant);
    }


    @Override
    public void removeEtudiant(Long idEtud) {
        etudRepository.deleteById(idEtud);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {

        return etudRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retreiveAllEtudiants() {
        return (List<Etudiant>) etudRepository.findAll();
    }

    public Optional<Etudiant> retrieveEtudiant(Long idEtudiant) {
        return etudRepository.findById(idEtudiant);
    }

    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) {
        Etudiant etudiant = etudRepository.findById(Long.valueOf(etudiantId)).get();
        Departement departement=depRepository.findById(Long.valueOf(departementId)).get();
        etudiant.setDepartement(departement);
        etudRepository.save(etudiant);

    };

    @Override
    public void addEtudiantContrats(List<Contrat> lc, Long idEtudiant) {
        Etudiant etudiant = etudRepository.findById(idEtudiant).orElse(null);
        for (Contrat contrat : lc) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }
    }
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe){
        Contrat contrat=contratRepository.findById(Long.valueOf(idContrat)).get();
        Equipe equipe=equipeRepository.findById(Long.valueOf(idEquipe)).get();

        e.getEquipes().add(equipe);

        Etudiant et =etudRepository.save(e);
        contrat.setEtudiant(et);
        contratRepository.save(contrat);
        
        return et;

    };

    @Override
    public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
        return etudRepository.findByDepartement_IdDepart(idDepartement.longValue());
    };

}
