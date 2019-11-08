package com.example.demo.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.autreObjet.Bon;
import com.example.demo.model.DetailBon;
import com.example.demo.model.EntetBon;
import com.example.demo.model.Produit;
import com.example.demo.service.IDetailBonServ;
import com.example.demo.service.IEnteteBonServ;
import com.example.demo.service.IProduitServ;

@Service
public class BonMetier {
	@Autowired
    private IEnteteBonServ iEnteteBonServ;
	
	@Autowired
	private IDetailBonServ iDetailBonServ;
	
	@Autowired
	private IProduitServ iProduitServ;
	
	private Bon res;
	public  List<Bon> listBon = null;
	
	public List<Bon> getAllBon(){
		List<EntetBon> list = iEnteteBonServ.getAllEnteteBon(); 
		if(list != null) {
			listBon = new ArrayList<>();	
			  list.forEach(item -> {
				List<DetailBon> dl =  iDetailBonServ.getDetailByIdEntete(item.getId());
			    listBon.add(new Bon(item,dl)); 
			  });	
		}
	return listBon;
	}
	
	public Bon getBon(long id) {
		Bon b = null;
		EntetBon eb = iEnteteBonServ.getEntetBonById(id);
		if(eb != null) {
			 b = new Bon();
			 b.setEntetBon(eb);
			 b.setListDetailBon(iDetailBonServ.getDetailByIdEntete(id));	
		}
		return b;
	}
	
	
	public Bon getBon(String code) {
		Bon b = null;
		EntetBon eb = iEnteteBonServ.getEntetBonByCode(code);
	    if(eb != null) {
			b = new Bon();
			b.setEntetBon(eb);
			b.setListDetailBon(iDetailBonServ.getDetailByIdEntete(b.getEntetBon().getId()));
			
		}
			return b ;
	}
	
	
	public List<Bon> getAllBonByIdClient(long idClidnt){
		List<EntetBon> list =  iEnteteBonServ.getAllEnteteBonByClient(idClidnt);
		if(list != null) { 
		  listBon = new ArrayList<>();	
		  list.forEach(item -> {
			List<DetailBon> dl =  iDetailBonServ.getDetailByIdEntete(item.getId());
		    listBon.add(new Bon(item,dl));
		     
		  });
		  
		}
		
		return listBon;
	}
	
	public Bon saveBon(Bon bon) { 
		if(bon.getEntetBon() != null) {
			res = new Bon();
			EntetBon entete =  iEnteteBonServ.saveEnteteBon(bon.getEntetBon());
			res.setEntetBon(entete);
			
			if(bon.getListDetailBon().size() != 0) {
				
				bon.getListDetailBon().forEach(item -> {
					item.setIdBonCommande(entete.getId());
					Produit p = iProduitServ.getProduit(item.getIdProduit());
					item.setTotal(item.getQte()*p.getPrix());});
				
				List<DetailBon> detail = iDetailBonServ.saveDetailBon(bon.getListDetailBon());
				res.setListDetailBon(detail);	
				//--------update qte -------
				bon.getListDetailBon().forEach(item ->{
					Produit p = iProduitServ.getProduit(item.getIdProduit());
					int qte  = (int) (p.getQteStock() - item.getQte());
					System.out.println("qte "+ qte +" id "+item.getIdProduit());
					iProduitServ.updateQte(qte, item.getIdProduit());
				});
				
			}
		    
		}
		return res;
	}
	
	public boolean deleteBon(long id) {
		boolean test = false;
		boolean res  = iDetailBonServ.deleteDetailBon(id);
		if(res == true) {
		  test = iEnteteBonServ.deleteEnteteBon(id);
		}
		return test;
	}
	
}
