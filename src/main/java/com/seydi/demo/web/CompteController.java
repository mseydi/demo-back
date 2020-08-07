package com.seydi.demo.web;

import com.seydi.demo.dao.CompteRepository;
import com.seydi.demo.dao.OperationRepository;
import com.seydi.demo.entities.Compte;
import com.seydi.demo.metier.BanOperationMetierImpl;
import com.seydi.demo.metier.BankOperationMetier;
import com.seydi.demo.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
public class CompteController{
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationRepository operationRepository;


    private BankOperationMetier bankOperationMetier  ;
    private BanOperationMetierImpl banOperationMetierImpl;
    // private Object Compte;

    @RequestMapping( value = "/comptes/{codeCompte}", method = RequestMethod.GET )
    public Compte getCompte( @PathVariable("codeCompte") String codeCompte ) {

        return compteRepository.findById( codeCompte ).get();
    }

    @RequestMapping("/all" )
    public List<Compte> getComptes(){
        return compteRepository.findAll();
            }

    // liste d'oprations avec méthode
    @RequestMapping( value = "/operations", method = RequestMethod.GET )
    public PageOperation getOperations(
            @RequestParam String codeCompte,
            @RequestParam int page,
            @RequestParam int size ) {
        return (PageOperation) bankOperationMetier.listOperations(codeCompte,page,size);
    }

    /**
     * Operation versement
     */
    @RequestMapping( value = "/versement", method = RequestMethod.PUT )
    public void verser(
            @RequestParam String code,
            @RequestParam double montant) {
         bankOperationMetier.verser( code, montant );
    }

    /**
     * Operation retrait via requeête PUT
     *
     */
    @RequestMapping( value = "/retrait", method = RequestMethod.PUT )
    public void retirer(
            @RequestParam String code,
            @RequestParam double montant) {
         bankOperationMetier.retirer( code, montant );
    }

    }