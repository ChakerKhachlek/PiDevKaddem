package com.example.firstcrud.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

@Table(name="universite")
@EnableAutoConfiguration
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String nomUniv;
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Departement> departement;

}