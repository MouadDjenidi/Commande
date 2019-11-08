package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.EntetBon;

public interface EnteteBonRepository extends JpaRepository<EntetBon, Long>{
	
	@Query(value = "select e from EntetBon e where e.code = ?1")
	public EntetBon getEnteteByCode(String code);
	
	@Query(value =  "SELECT e FROM EntetBon e WHERE e.idClient = ?1 ")
	public List<EntetBon> getByIdClient(long id);

}
