package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "produit",schema = "audaxis")
@Data
public class Produit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "The database generated produit id")
	private long id;
	
	@NotBlank
	@ApiModelProperty(value = "the code must be unique")
	private String code;
	
	private String libelle;
	private String marque;
	private String categorie;
	private double prix;
	private int  qteStock;

}
