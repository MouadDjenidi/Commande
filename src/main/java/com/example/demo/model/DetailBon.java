package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "detail_bon",schema = "audaxis")
@Data
public class DetailBon {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private long id ;
	
	   @Column(name="qte")
	   private long   qte;
	   
	   @Column(name="total")
	   private double total;
	   
	   @Column(name="entet_bon_id")
	   private long idBonCommande; 

	   @Column(name="produit_id")
	   private long idProduit;
}
