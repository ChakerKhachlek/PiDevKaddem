package com.example.firstcrud.entities;


import com.example.firstcrud.entities.Etudiant;
import com.example.firstcrud.entities.Specialite;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Data : not adviced
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private Boolean archive;

    private int montantContrat;
    @ManyToOne(cascade =CascadeType.PERSIST)
    private Etudiant etudiant;
}

