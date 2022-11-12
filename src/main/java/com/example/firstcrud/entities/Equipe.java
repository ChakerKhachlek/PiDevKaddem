package com.example.firstcrud.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(mappedBy = "equipes",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants ;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;

    public Equipe() {
    }
}
