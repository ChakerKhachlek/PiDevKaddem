package com.example.firstcrud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name="details_equipes")
@EnableAutoConfiguration
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle ;
    private String thematique;

    @JsonIgnore
    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe ;


    public DetailEquipe() {

    }
}
