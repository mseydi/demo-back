package com.seydi.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@ToString
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 1, name = "TYPE_OP")
public class Operation implements Serializable {

    @Id
    @GeneratedValue
    private Long numeroOperation;
    private Date dateOperation;
    private double montant;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codeCompte")
    private Compte compte;


    public Operation( Date dateOperation, double montant ) {
        this.dateOperation = dateOperation;
        this.montant = montant;
    }
    public Operation(){
        super();
    }



//    public Operation(Long numeroOperation, Date dateOperation, double montant, Compte compte ) {
//        super();
//        this.numeroOperation = numeroOperation;
//        this.dateOperation = dateOperation;
//        this.montant = montant;
//        this.compte = compte;
//    }

    public Long getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation( Long numeroOperation ) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation( Date dateOperation ) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant( double montant ) {
        this.montant = montant;
    }
    public Compte getCompte() {
        return compte;
    }

    public void setCompte( Compte compte ) {
        this.compte = compte;
    }
}
