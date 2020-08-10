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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BanOperationMetierImpl {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;




    @Transactional
    public  boolean verser(String codeCompte, double montant) {
        Compte cp = compteRepository.getOne(codeCompte);
        Operation o = new Versement();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        operationRepository.save( o );
        cp.setSolde( cp.getSolde() + montant );
        return true;


    }

   @Transactional
    public  boolean retirer(String codeCompte, double montant) {
        Compte cp = compteRepository.findById(codeCompte).get();
        if(cp.getSolde()<montant)throw  new RuntimeException("Solde Insufisant");
        Operation o = new Versement();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        operationRepository.save( o );
        cp.setSolde( cp.getSolde() - montant );
        return true;

    }


  /* public PageOperation getOperations(String codeCompte, int page, int size) {
      *//*Page<Operation> ops = operationRepository.getOperation(codeCompte, page,size);
       PageOperation pOp = new PageOperation();
      pOp.setOperations(ops.getContent());
      pOp.setNmbreOperations(ops.getNumberOfElements());
      pOp.setPage(ops.getNumber());
      pOp.setTotalPages(ops.getTotalPages());*//*
       Compte cp = compteRepository.findById( codeCompte ).get();
       //PageOperation pOp = new PageOperation();
       Page<Operation> ops = operationRepository.findByCompte(cp, Pageable.unpaged());
      return (PageOperation) ops;


    }*/
/*  public PageOperation getOperations(String codeCompte, int page, int size) {
      Page<Operation> ops = operationRepository.getOperation(codeCompte, page,size);
       PageOperation pOp = new PageOperation();
      pOp.setOperations(ops.getContent());
      pOp.setNmbreOperations(ops.getNumberOfElements());
      pOp.setPage(ops.getNumber());
      pOp.setTotalPages(ops.getTotalPages());
      Compte cp = compteRepository.findById( codeCompte ).get();
      return (PageOperation) ops;


  }*/


//    public List<Operation> listOperations(Compte cp) {
//        return operationRepository.findByCompte(cp);
//    }




    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteRepository.findById(codeCompte).get();
        if(cp==null) throw  new RuntimeException("Compte innexistant");
            return cp;
    }
}
