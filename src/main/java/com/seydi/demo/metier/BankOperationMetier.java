package com.seydi.demo.metier;

import com.seydi.demo.dao.CompteRepository;
import com.seydi.demo.dao.OperationRepository;
import com.seydi.demo.entities.Compte;
import com.seydi.demo.entities.Operation;
import com.seydi.demo.entities.Retrait;
import com.seydi.demo.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
@Service
@Transactional
public interface BankOperationMetier {
    public Compte consulterCompte(String codeCompte);

    // Operation verssement
    public boolean verser( String code, double montant);

    // retirer
    public boolean retirer( String code, double montant );

    public PageOperation listOperations(String codeCompte, int page, int size );


}
