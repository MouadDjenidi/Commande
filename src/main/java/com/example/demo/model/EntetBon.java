package com.example.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "entete_bon",schema = "audaxis")
@Data
public class EntetBon {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@Column(name="code")
	@NotBlank
	private String code;
	
	@Column(name="date_bon")
	private Date dateBon;
	
	@Column(name="date_reglement")
	private Date dateReglement;
	
	@Column(name="moyen_paiement")
	private String moyenPaiement;
	
	@Column(name="client_id")
	private long idClient;
}
