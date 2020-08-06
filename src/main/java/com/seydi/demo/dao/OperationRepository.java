package com.seydi.demo.dao;

import com.seydi.demo.entities.Compte;
import com.seydi.demo.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long> {

    public Page<Operation> findByCompte(Compte compte, Pageable pageable);



    public default void verser( Compte compte, double montant) {
        compte.setSolde(compte.getSolde() + montant);
    }


    public default void retirer( Compte compte, double montant) {
        compte.setSolde(compte.getSolde() - montant);

    }

}
