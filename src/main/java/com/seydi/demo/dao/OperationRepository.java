package com.seydi.demo.dao;

import com.seydi.demo.entities.Compte;
import com.seydi.demo.entities.Operation;
import com.seydi.demo.metier.PageOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long> {

 //   @Query("select o from Operation o where o.compte.codeCompte=:x")
 //   public Page<Operation> listOperation(@Param("x") String codeCompte, Pageable pageable);

//    @Query("select o from Operation o where o.compte.codeCompte=:x")
//    public Page<Operation> getOperation(@Param("x") String codeCompte, int page, Pageable pageable);


    public Page<Operation> findByCompte(Compte cp, Pageable pageable);
    //public List<Operation> findByCompte(Compte cp);

    @Query("select o from Operation o where o.compte.codeCompte=:x")
    public List<Operation> getOperation(@Param("x") String codeCompte);

}
