package com.example.firstcrud.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table( name= "contrats")
@EnableAutoConfiguration

public class Contrat implements Serializable {


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public Contrat() {
    }

    public Contrat(long idContrat, Date dateDebutContract, Date dateFinContrat, Specialite specialite, Boolean archive, Long montantContrat) {
        this.idContrat = idContrat;
        this.dateDebutContract = dateDebutContract;
        this.dateFinContrat = dateFinContrat;
        this.specialite = specialite;
        this.archive = archive;
        this.montantContrat = montantContrat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContrat", nullable = false)
    private long idContrat;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDebutContract", nullable = false)
    private Date dateDebutContract;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateFinContrat", nullable = false)
    private Date dateFinContrat;


    public enum Specialite{
        IA,RESEAUX,CLOUD,SECURITE
    }

    @Column(name = "specialite", nullable = false)
    private Specialite specialite;

    @Column(name = "archive", nullable = false)
    private Boolean archive;

    @Column(name = "montantContrat", nullable = false)
    private Long montantContrat;

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }



    public long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(long idContrat) {
        this.idContrat = idContrat;
    }

    public Date getDateDebutContract() {
        return dateDebutContract;
    }

    public void setDateDebutContract(Date dateDebutContract) {
        this.dateDebutContract = dateDebutContract;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Long getMontantContrat() {
        return montantContrat;
    }

    public void setMontantContrat(Long montantContrat) {
        this.montantContrat = montantContrat;
    }
}