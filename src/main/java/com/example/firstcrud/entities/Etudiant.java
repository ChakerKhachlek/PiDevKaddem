package com.example.firstcrud.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity

@EnableAutoConfiguration
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name= "etudiants")
public class Etudiant implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="prenom")
    private String prenom;
    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="etuOption")
    private Option option;
    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @OneToMany(mappedBy = "etudiant", orphanRemoval = true,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Contrat> contrats = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Equipe> equipes = new LinkedHashSet<>();




    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}