package com.seydi.demo.web;

import com.seydi.demo.dao.CompteRepository;
import com.seydi.demo.dao.OperationRepository;
import com.seydi.demo.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CompteController{
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    OperationRepository operationRepository;
    private Object Compte;



    @RequestMapping("/get")
    public Compte getCompte(Long idCompte){
        return compteRepository.getOne(idCompte);
    }

    @RequestMapping("/save")
    public Compte saveCompte(Compte c){
        c.setDateCreation( new Date() );
        compteRepository.save(c);
        return c;
    }
    @RequestMapping("/all")
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }

    @RequestMapping("/delete")
    public boolean delete(Long id){
        compteRepository.deleteById(id);
        return true;
    }

      @RequestMapping(value="/saveOperation", method= RequestMethod.POST)
      	public String saveOperation(double montant, Compte compte){

                    operationRepository.verser(compte, montant);
                    operationRepository.retirer(compte, montant);

          return "redirect:/getCompte?idCompte="+compte;

            }





    }