package com.example.firstcrud.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity

@EnableAutoConfiguration
@NoArgsConstructor
@Table( name= "etudiants")
public class Etudiant implements Serializable {
    public Etudiant(String nom, String prenom, Option option) {
        this.nom = nom;
        this.prenom = prenom;
        this.option = option;
    }
    

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

    @OneToMany(mappedBy = "etudiant", orphanRemoval = true,cascade = CascadeType.ALL)
    private Set<Contrat> contrats = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "etudiants")
    private Set<Equipe> equipes = new LinkedHashSet<>();

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }



    public Set<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomE) {
        this.nom = nomE;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenomE) {
        this.prenom = prenomE;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Etudiant etudiant = (Etudiant) o;
        return id != null && Objects.equals(id, etudiant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

   @OneToMany(cascade = CascadeType.ALL ,mappedBy = "etudiant")
   private Set<Contrat> contrat;
   @ManyToMany(cascade = CascadeType.ALL)

   private Set<Equipe> equipes ;

}

