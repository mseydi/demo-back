package com.seydi.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Compte implements Serializable {
    @Id
    @GeneratedValue
    private  String codeCompte;
    private String titulaire;
    private double solde;
    private Date dateCreation;
    private boolean etat;
    @OneToMany(mappedBy="compte",fetch = FetchType.EAGER)
    private List<Operation> operations;

    public Compte(){
        super();
    }
    public Compte(String titulaire, String codeCompte, Date dateCreation, double solde ) {
        super();
        this.titulaire = titulaire;
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }


    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte( String codeCompte ) {
        this.codeCompte = codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( Date dateCreation ) {
        this.dateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde( double solde ) {
        this.solde = solde;
    }


}
