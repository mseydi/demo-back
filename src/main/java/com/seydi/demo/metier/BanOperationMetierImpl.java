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
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Date;

public class BanOperationMetierImpl implements BankOperationMetier{
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    private BankOperationMetier bankOperationMetier ;
   // @Transactional
   // si tous ce passe bien la transaction et faite
    public  void verser(String codeCompte, double montant) {
        Compte cp = bankOperationMetier.consulterCompte(codeCompte);
        Operation o = new Versement(new Date(),montant);
        operationRepository.save( o );
        cp.setSolde( cp.getSolde() + montant );


    }

   // @Transactional
    public  void retirer(String codeCompte, double montant) {
        Compte cp = bankOperationMetier.consulterCompte(codeCompte);
        if(cp.getSolde()<montant)throw  new RuntimeException("Solde Insufisant");
        Operation o = new Retrait(new Date(),montant);
        operationRepository.save( o );
        cp.setSolde( cp.getSolde() - montant );


    }

    @Override
    public Page<Operation> listOperations(String codeCompte, int page, int size) {
        return operationRepository.listOperation(codeCompte,PageRequest.of(page, size, Sort.by("")));
    }


//    public static PageOperation getOperations(String codeCompte, int page, int size) {
//
//        Page<Operation> ops = operationRepository.getOperations( codeCompte, new PageRequest( page, size ) );
//
//        PageOperation pOp = new PageOperation();
//        pOp.setOperations( ops.getContent() ); // get content retourne la liste
//        // des operations
//        pOp.setNmbreOperations( ops.getNumberOfElements() ); // nombre
//        // operations
//        pOp.setPage( page ); // ops.getNumber()
//        pOp.setTotalPages( ops.getTotalPages() );
//        pOp.setTotalOperations((int) ops.getTotalElements() );
//        return pOp;
//
//    }

    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteRepository.findById(codeCompte).get();
        if(cp==null) throw  new RuntimeException("Compte innexistant");
            return  cp;
    }
}
