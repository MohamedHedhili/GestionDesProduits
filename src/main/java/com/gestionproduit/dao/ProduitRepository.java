package com.gestionproduit.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionproduit.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
@Query("select   p  from  Produit p  where p.designiation like :x")
	public  Page<Produit> findProduit (@Param("x")String  mc , Pageable pageable) ; 
}
