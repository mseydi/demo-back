package com.seydi.demo.web;

import com.seydi.demo.dao.CompteRepository;
import com.seydi.demo.dao.OperationRepository;
import com.seydi.demo.entities.Compte;
import com.seydi.demo.entities.Operation;
import com.seydi.demo.metier.BanOperationMetierImpl;
import com.seydi.demo.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@CrossOrigin("*")
@RestController
public class CompteController{
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    private BanOperationMetierImpl banOperationMetierImpl  ;

    @RequestMapping( value = "/comptes/{codeCompte}", method = RequestMethod.GET )
    public Compte getCompte( @PathVariable("codeCompte") String codeCompte ) {

        return compteRepository.findById( codeCompte ).get();
    }

    @RequestMapping("/all" )
    public List<Compte> getComptes(){
        return compteRepository.findAll();
            }

   //  liste d'oprations avec méthode
   /* @RequestMapping( value = "/operations", method = RequestMethod.GET )
    public PageOperation getOperations(
            @RequestParam String codeCompte,
            @RequestParam int page,
            @RequestParam int size ) {
        return (PageOperation) banOperationMetierImpl.getOperations(codeCompte,page,size);
    }*/
    @RequestMapping( value = "/operations", method = RequestMethod.GET )
    public  List<Operation> getOperations(String codeCompte) {
        List<Operation> listop = operationRepository.getOperation(codeCompte);
        return listop;
    }
    /**
     * Operation versement
     */
    @RequestMapping( value = "/versement", method = RequestMethod.PUT)
    public boolean verser(
            @RequestParam String codeCompte,
            @RequestParam double montant) {
        return banOperationMetierImpl.verser( codeCompte, montant );
    }

    /**
     * Operation retrait via requeête PUT
     *
     */
    @RequestMapping( value = "/retrait", method = RequestMethod.PUT )
    public boolean retirer(
            @RequestParam String codeCompte,
            @RequestParam double montant) {
         return banOperationMetierImpl.retirer( codeCompte, montant );
    }

    }