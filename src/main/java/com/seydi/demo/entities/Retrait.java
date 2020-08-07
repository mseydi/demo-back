package com.seydi.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@DiscriminatorValue("R")
public class Retrait  extends  Operation{

    public Retrait() {
        super();
    }


    public Retrait(Date dateOperation, double montant) {
        super(dateOperation, montant);
    }
}
