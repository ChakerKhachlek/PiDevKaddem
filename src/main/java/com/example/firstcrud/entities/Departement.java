package com.example.firstcrud.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="departements")
@EnableAutoConfiguration
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departement", nullable = false)
    private Integer idDepartement;

    @Column(name = "nomDepart", nullable = false)
    private String nomDepart;

    @OneToMany(mappedBy = "departement", orphanRemoval = true)
    private Set<Etudiant> etudiants = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "univ_id")
    private Universite universite;

    public Departement(String nomDepart){
        this.nomDepart=nomDepart;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Integer getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }
}
