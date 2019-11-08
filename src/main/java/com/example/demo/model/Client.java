package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "client",schema = "audaxis")
@Data
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@NotBlank
	private String code;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
}
