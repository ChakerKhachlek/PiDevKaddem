package com.example.firstcrud.services;
import com.example.firstcrud.entities.Contrat;

import com.example.firstcrud.entities.Equipe;
import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.repositories.IContratRepository;
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
    

    public EtudiantService(IEtudRepository etudRepository) {
        this.etudRepository = etudRepository;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant){
        return etudRepository.save(etudiant);
    }


    @Override
    public void removeEtudiant(Integer idEtud) {
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

    public Optional<Etudiant> retrieveEtudiant(Integer idEtudiant) {
        return etudRepository.findById(idEtudiant);
    }

    @Override
    public void addEtudiantContrats(List<Contrat> lc, Integer idEtudiant) {
        Etudiant etudiant = etudRepository.findById(idEtudiant).orElse(null);
        for (Contrat contrat : lc) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }
    }


}
