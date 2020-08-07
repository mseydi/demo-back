package com.seydi.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity


@DiscriminatorValue("V")
public class Versement extends  Operation{

    public Versement(){
        super();

    }
    public Versement(Date date, double montant){
        super(date, montant);
    }




}
