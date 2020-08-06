package com.seydi.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idCompte;
    private String titulaire;
    private double solde;
    private Date dateCreation;
    private boolean etat;
    @OneToMany(mappedBy="compte")
    private Collection<Operation> operations;
}
