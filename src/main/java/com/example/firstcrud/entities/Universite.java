package com.example.firstcrud.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="universites")
@EnableAutoConfiguration
@Getter
@Setter
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;


    @Column(name = "nom_universite")
    private String nomUniv;



    @OneToMany(mappedBy = "universite", orphanRemoval = true)
    private Set<Departement> departements = new LinkedHashSet<>();

}