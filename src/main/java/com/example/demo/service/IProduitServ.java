package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Produit;

public interface IProduitServ {
	public List<Produit> getAllProduit();
	public Produit getProduit(long id);
    public Produit getProduit(String code);
    public Produit saveProduit(Produit p);
    public boolean deleteProduit(long id);
    public void updateQte(int qte,long id);
    public List<Produit> getStockVide();
}
