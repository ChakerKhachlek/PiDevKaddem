package com.example.firstcrud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="departments")
@AllArgsConstructor
@Getter
@Setter
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;

    @Column(name = "nom_departmenet",nullable = false)
    private String nomDepart;

    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "universite_id")
    @JsonIgnore
    private Universite universite;

    public Departement() {

    }
}

