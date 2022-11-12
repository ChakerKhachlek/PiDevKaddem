package com.example.firstcrud.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
<<<<<<< HEAD
@Table(name="detailsequipes")
@EnableAutoConfiguration
public class DetailEquipe implements Serializable {
=======
public class DetailEquipe {
>>>>>>> master
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle ;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe",cascade= CascadeType.ALL)
    private Equipe equipe ;
}
