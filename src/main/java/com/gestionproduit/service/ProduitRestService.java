package com.gestionproduit.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionproduit.dao.ProduitRepository;
import com.gestionproduit.entities.Produit;

@RestController
public class ProduitRestService {
	@Autowired
	private  ProduitRepository produitRepo ; 
	
	@RequestMapping(value="/findProduits" , method= RequestMethod.GET)
	public  Page<Produit> find (String mc ,
			@RequestParam(name ="page" ,defaultValue="0")int  page ,  
			@RequestParam(name ="size" ,defaultValue="4")int size )
	{return produitRepo.findProduit("%"+mc+"%", new PageRequest(page, size)) ;}
	
	
	@RequestMapping(value="/produits" , method= RequestMethod.GET)
	public  Page<Produit> listProduits (@RequestParam(name ="page" ,defaultValue="0") int  page ,@RequestParam(name ="size" ,defaultValue="4")  int size )
	{return produitRepo.findAll(new PageRequest(page, size)) ;}
	@RequestMapping(value="/produits/{id}" , method= RequestMethod.GET)
	public  Produit getProduit (@PathVariable("id")Long id)
	{return produitRepo.findOne(id) ;}
	
	@RequestMapping(value="/produits" , method= RequestMethod.POST)
	public  Produit save (@RequestBody  Produit p)
	{return produitRepo.save(p) ;}
	@RequestMapping(value="/produits/{id}" , method= RequestMethod.PUT)
	public  Produit update (@RequestBody  Produit p ,@PathVariable ("id")Long id)
	{   p.setId(id);
		return produitRepo.saveAndFlush(p) ;}
	
	@RequestMapping(value="/produits/{id}" , method= RequestMethod.DELETE)
	public  void delete (@PathVariable ("id")Long id)
	{  produitRepo.delete(id) ;}
}
