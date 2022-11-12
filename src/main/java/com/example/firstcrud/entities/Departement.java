package com.example.firstcrud.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Etudiant> etudiant;


}