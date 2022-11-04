package com.example.firstcrud.entities;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name="DetailsEquipes")
@EnableAutoConfiguration
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_equipe_id", nullable = false)
    private Long idDetailEquipe;

    @Column(name = "salle", nullable = false)
    private Long salle;

    @Column(name = "thematique", nullable = false)
    private String thematique;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Long getIdDetailEquipe() {
        return idDetailEquipe;
    }

    public void setIdDetailEquipe(Long idDetailEquipe) {
        this.idDetailEquipe = idDetailEquipe;
    }

    public Long getSalle() {
        return salle;
    }

    public void setSalle(Long salle) {
        this.salle = salle;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }
}
