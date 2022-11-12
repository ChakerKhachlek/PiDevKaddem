package com.example.firstcrud.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Departments")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;



    private String nomDepart;
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Etudiant> etudiant;



}



