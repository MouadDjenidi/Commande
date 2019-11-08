package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	@Query(value =  "SELECT p FROM Produit p WHERE p.code = ?1")
	public Produit findByName(String code);
	
	@Query(value = "SELECT p FROM Produit p WHERE p.qteStock = 0 ")
	public List<Produit> getStockVide();
	
	@Modifying
	@Query(value = "update Produit p set p.qteStock = :qte where p.id = :id")
	public void qteProduit(@Param("id") long id , @Param("qte") int qte);
}
