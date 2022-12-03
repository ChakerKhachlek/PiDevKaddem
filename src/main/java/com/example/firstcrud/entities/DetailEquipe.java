package com.example.firstcrud.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="details_equipes")
@EnableAutoConfiguration
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle ;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe",cascade= CascadeType.ALL)
    private Equipe equipe ;
}
