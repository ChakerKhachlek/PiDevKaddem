package com.example.firstcrud.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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
        this.nomE = nom;
        this.prenomE = prenom;
        this.option = option;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    @Column(name="firstname")
    private String prenomE;
    @Column(name="lastname")
    private String nomE;
    @Enumerated(EnumType.STRING)
    @Column(name="etuOption")
    private Option option;
    @ManyToOne

    @JsonIgnore

    private Departement departement;

    @OneToMany(mappedBy = "etudiant", orphanRemoval = true,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Contrat> contrats = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
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

    public Long getId() {
        return idEtudiant;
    }

    public void setId(Long id) {
        this.idEtudiant = id;
    }

    public String getNom() {
        return nomE;
    }

    public void setNom(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenom() {
        return prenomE;
    }

    public void setPrenom(String prenomE) {
        this.prenomE = prenomE;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }



    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}