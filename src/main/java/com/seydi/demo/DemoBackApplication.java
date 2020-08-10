package com.seydi.demo;

import com.seydi.demo.dao.CompteRepository;
import com.seydi.demo.dao.OperationRepository;
import com.seydi.demo.entities.Compte;
import com.seydi.demo.entities.Operation;
import com.seydi.demo.metier.BankOperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoBackApplication implements CommandLineRunner {
    @Autowired
	CompteRepository compteRepository;
    @Autowired
	OperationRepository operationRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoBackApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*compteRepository.save(new Compte(null, "Momo",5000, new Date(05-20-2020),true,""));
		compteRepository.save(new Compte(null, "Tatoo",15000, new Date(06-20-2020),true, ""));
		compteRepository.save(new Compte(null, "Ami",10000, new Date(01-20-2020),true,""));
		compteRepository.save(new Compte(null, "Ouz",7000, new Date(15-20-2020),false,""));*/

//		compteRepository.findAll().forEach((c->{
//			System.out.println(c.toString());
//	}));


}

}