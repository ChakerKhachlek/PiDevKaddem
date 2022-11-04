package com.example.firstcrud.entities;

import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="equipes")
@EnableAutoConfiguration
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe", nullable = false)
    private Long idEquipe;

    @ManyToMany
    @JoinTable(name = "equipes_etudiants",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiants_id"))
    private Set<Etudiant> etudiants = new LinkedHashSet<>();


    public enum Niveau{
        JUNIOR,SENIOR,EXPERT
    }

    @Column(name = "niveau", nullable = false)
    private Niveau niveau;

    @OneToOne(mappedBy = "equipe", orphanRemoval = true)
    private DetailEquipe detailEquipe;

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }


    public DetailEquipe getDetailEquipe() {
        return detailEquipe;
    }

    public void setDetailEquipe(DetailEquipe detailEquipe) {
        this.detailEquipe = detailEquipe;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Equipe equipe = (Equipe) o;
        return idEquipe != null && Objects.equals(idEquipe, equipe.idEquipe);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
