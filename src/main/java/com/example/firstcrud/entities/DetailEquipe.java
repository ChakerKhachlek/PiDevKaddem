package com.example.firstcrud.entities;

import javax.persistence.*;

@Entity
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle ;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe",cascade= CascadeType.ALL)
    private Equipe equipe ;
}
