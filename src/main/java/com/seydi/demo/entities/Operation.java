package com.seydi.demo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    @Id
    @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private double montant;
    private String typeOpe[]={"VERS", "RET"};
    @ManyToOne
    @JoinColumn(name="idCOmpte")
    private Compte compte;

}
