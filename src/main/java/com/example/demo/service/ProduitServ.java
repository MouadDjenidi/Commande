package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProduitRepository;
import com.example.demo.model.Produit;

@Service
public class ProduitServ implements IProduitServ{
	
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public List<Produit> getAllProduit() {
		return produitRepository.findAll();
	}

	@Override
	public Produit getProduit(long id) {
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public Produit getProduit(String code) {
		return produitRepository.findByName(code);
	}

	@Override
	public Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}
	
	@Override
	public boolean deleteProduit(long id) {
		boolean test = false;
		try {
			produitRepository.deleteById(id);
			test = true;
		} catch (Exception e) {
			test = false;
		}
		return test;
	}

	@Override
	public void updateQte(int qte,long id) {
		produitRepository.qteProduit(id,qte);
	}

	@Override
	public List<Produit> getStockVide() {
		return produitRepository.getStockVide();
	}

}
