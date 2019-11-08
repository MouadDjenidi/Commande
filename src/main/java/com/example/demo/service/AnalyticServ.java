package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.autreObjet.BestSelling;

@Service
public class AnalyticServ implements IAnalyticServ{
	
	@Autowired
    private  JdbcTemplate jdbcTemplate;
    
	@Override
	public List<BestSelling> bestSellingQte() {
		    String sql =  " select tab1.qte , tab1.idproduit ,tab2.code , tab2.libelle as model , tab2.marque , tab2.categorie ,tab2.prix ,tab2.qte_stock "
		    		     +" from(select  sum(qte) as qte , produit_id as idproduit from detail_bon group by produit_id) as tab1 "
		    		     +" inner join produit as tab2 on tab1.idproduit = tab2.id ;";
                                     
		try {	
			 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			 List<BestSelling>  bestSelling= new ArrayList<>();
			 for (Map<String, Object> row : rows) {
				 BestSelling b = new BestSelling();
				 b.setVar(Double.parseDouble(String.valueOf(row.get("qte"))));
				 b.getProduit().setId(Integer.parseInt(String.valueOf(row.get("idproduit"))));
				 b.getProduit().setCode(String.valueOf(row.get("code")));
				 b.getProduit().setLibelle(String.valueOf(row.get("model")));
				 b.getProduit().setMarque(String.valueOf(row.get("marque")));
				 b.getProduit().setCategorie(String.valueOf(row.get("categorie")));
				 b.getProduit().setPrix(Double.parseDouble(String.valueOf(row.get("prix"))));
				 b.getProduit().setQteStock(Integer.parseInt(String.valueOf(row.get("qte_stock"))));
				 bestSelling.add(b);
			 }
			 return bestSelling;
		} catch (Exception e) {
			return null;	
		}
	}

	@Override
	public List<BestSelling> bestSellingTotal() {
		 String sql =  " select tab1.total , tab1.idproduit ,tab2.code , tab2.libelle as model , tab2.marque , tab2.categorie ,tab2.prix ,tab2.qte_stock "
    		     +" from(select  sum(total) as total , produit_id as idproduit from detail_bon group by produit_id) as tab1 "
    		     +" inner join produit as tab2 on tab1.idproduit = tab2.id ;";
                             
			try {	
				 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
				 List<BestSelling>  bestSelling= new ArrayList<>();
				 for (Map<String, Object> row : rows) {
					 BestSelling b = new BestSelling();
					 b.setVar(Double.parseDouble(String.valueOf(row.get("total"))));
					 b.getProduit().setId(Integer.parseInt(String.valueOf(row.get("idproduit"))));
					 b.getProduit().setCode(String.valueOf(row.get("code")));
					 b.getProduit().setLibelle(String.valueOf(row.get("model")));
					 b.getProduit().setMarque(String.valueOf(row.get("marque")));
					 b.getProduit().setCategorie(String.valueOf(row.get("categorie")));
					 b.getProduit().setPrix(Double.parseDouble(String.valueOf(row.get("prix"))));
					 b.getProduit().setQteStock(Integer.parseInt(String.valueOf(row.get("qte_stock"))));
					 bestSelling.add(b);
				 }
				 return bestSelling;
			} catch (Exception e) {
				return null;	
			}
	}

}
