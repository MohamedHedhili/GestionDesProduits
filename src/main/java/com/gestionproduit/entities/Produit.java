package com.gestionproduit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

@Entity 
public class Produit  implements Serializable  {
	@Id @GeneratedValue
	private long id  ; 
	private String  designiation  ; 
	@DecimalMin("400")
	private double prix  ;   
	private  int  quantite  ;
	
	
	public Produit(String designiation, double prix, int quantite) {
		super();
		this.designiation = designiation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesigniation() {
		return designiation;
	}
	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	} 
	
	
	
	

}

