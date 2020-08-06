package com.seydi.demo.dao;

import com.seydi.demo.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository  extends JpaRepository<Compte, Long> {



}
