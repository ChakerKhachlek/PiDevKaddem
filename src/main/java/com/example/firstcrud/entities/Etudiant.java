package com.example.firstcrud.entities;

import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@Table( name= "etudiants")
public class Etudiant implements Serializable {
    public Etudiant(String nom, String prenom, Option option) {
        this.nom = nom;
        this.prenom = prenom;
        this.option = option;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;



    public enum Option{
        GAMIX,SE,SIM,NIDS
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "etu_option", nullable = false)
    private Option option;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;




    @OneToMany(mappedBy = "etudiant", orphanRemoval = true,cascade = CascadeType.ALL)
    private Set<Contrat> contrats = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "etudiants")
    private Set<Equipe> equipes = new LinkedHashSet<>();

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }



    public Set<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomE) {
        this.nom = nomE;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenomE) {
        this.prenom = prenomE;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Etudiant etudiant = (Etudiant) o;
        return id != null && Objects.equals(id, etudiant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
