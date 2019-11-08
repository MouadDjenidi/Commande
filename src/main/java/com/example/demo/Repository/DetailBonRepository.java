package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.DetailBon;

public interface DetailBonRepository extends JpaRepository<DetailBon, Long>{
	
	@Query(value =  "SELECT d FROM DetailBon d WHERE d.idBonCommande = ?1 ")
	public List<DetailBon> getById(long id);
	
	
	@Modifying
	@Query(value =  "DELETE FROM DetailBon d where d.idBonCommande = :id ")
	public int deleteDeatilBon(@Param("id") long id);
	
}