package com.example.firstcrud.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    @Column(name="firstname")
    private String prenomE;
    @Column(name="lastname")
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
   @ManyToOne
    private Departement departement;


   @OneToMany(cascade = CascadeType.ALL ,mappedBy = "etudiant")
   private Set<Contrat> contrat;
   @ManyToMany(cascade = CascadeType.ALL)
   private Set<Equipe> equipes ;
}

