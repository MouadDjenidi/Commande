package com.example.demo.autreObjet;

import com.example.demo.model.Produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestSelling {
	
	private double var;
	private Produit produit = new Produit();

}
