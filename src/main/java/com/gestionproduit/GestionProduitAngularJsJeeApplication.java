package com.gestionproduit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionproduit.dao.ProduitRepository;
import com.gestionproduit.entities.Produit;

@SpringBootApplication
public class GestionProduitAngularJsJeeApplication implements CommandLineRunner {
@Autowired
private ProduitRepository produitRepository ;
	public static void main(String[] args) {
		SpringApplication.run(GestionProduitAngularJsJeeApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
	//	produitRepository.save(new Produit("Stylo",500,350)) ;
	}
}
