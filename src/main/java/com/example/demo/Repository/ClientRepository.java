package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("SELECT c FROM Client c where c.code = :code ")
	public Client getClientByCode(@Param("code") String code);
	
	@Query("SELECT c FROM Client c where LOWER(c.nom) = LOWER(:nom) and LOWER(c.prenom) = LOWER(:prenom) ")
	public Client getClientByNP(@Param("nom") String nom , @Param("prenom") String prenom);
}