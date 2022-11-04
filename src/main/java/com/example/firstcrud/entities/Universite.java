package com.example.firstcrud.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name="universites")
@EnableAutoConfiguration
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_univ", nullable = false)
    private Long idUniv;

    @Column(name = "nomUniv", nullable = false)
    private String nomUniv;

    public Long getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(Long idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }
}
