package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produit;
import com.example.demo.service.IProduitServ;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Produit")
@RefreshScope
@Api(value = "produit management" , description = "Produit management end points")
public class ProduitController {
	
	@Autowired
	private IProduitServ iProduitServ;
	
	@ApiOperation(value = "view list of produit")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<produit>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/produits")
	public ResponseEntity<List<Produit>> getAllProduit(){
		List<Produit> res = iProduitServ.getAllProduit();
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);	
		}
	}
	
	@ApiOperation(value = "view produit when id is ?")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully retrieving produit by id"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404,message = "The resource you were trying to reach is not found")
			
	})
	@GetMapping("/produitID/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable long id){
		Produit p  = iProduitServ.getProduit(id);
		if(p == null){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(p);
		}
	}	
	
	@ApiOperation(value = "view produit when code is ?")
	@ApiResponses(value =  {
			@ApiResponse(code = 200,message = "Successfully retrieving produit by code"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/produitCode/{code}")
	public ResponseEntity<Produit> getProduitById(@PathVariable String code){
		Produit p = iProduitServ.getProduit(code);
		if(p == null) {
			return  ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(p);
		}
	}
	
	@ApiOperation(value = "save a produit")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully inserting produit"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@PostMapping("/produitSaves")
	public ResponseEntity<Produit> saveProduit(@RequestBody Produit p){
		Produit resp = iProduitServ.saveProduit(p);
		return ResponseEntity.ok(resp);
	}
	
	
	@ApiOperation(value = "delete a produit")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully deleting produit"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	
	@DeleteMapping("/produitDelete/{id}")
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "this product is used at least once")
	public ResponseEntity<Boolean> deleteProduit(@PathVariable long id){
		Boolean b = iProduitServ.deleteProduit(id);
		return ResponseEntity.ok(b);
	}
	
	
	@ApiOperation(value = "get list produit when stock vide")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully get the lsit"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/stockVide")
	public ResponseEntity<List<Produit>> getStockVide(){
		List<Produit> p = iProduitServ.getStockVide();
		if(p == null || p.size() == 0) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(p);
		}
		 
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("hello test");
	}
}
