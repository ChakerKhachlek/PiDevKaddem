package com.example.firstcrud.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@EnableAutoConfiguration
@Getter
@Setter
@Table( name= "equipes")
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;


    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    @OneToOne(cascade = CascadeType.REMOVE)
    private DetailEquipe detailEquipe;

    @ManyToMany(mappedBy = "equipes",cascade = CascadeType.REMOVE)
    private Set<Etudiant> etudiants = new LinkedHashSet<>();

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Equipe() {
    }
}
