package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.autreObjet.Bon;
import com.example.demo.metier.BonMetier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Bon")
@RefreshScope
@Api(value = "Bon management" , description = "bon end points")
public class BonController {
   
	@Autowired
	private BonMetier bonMetier;
	
	@ApiOperation(value = "view list of Bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<Bon>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/allBon")
	public ResponseEntity<List<Bon>> getAllBon(){
		List<Bon> res = bonMetier.getAllBon();
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view Bon by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving Bon by id"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/BonById/{id}")
	public ResponseEntity<Bon> getBon(@PathVariable long id){
		Bon res = bonMetier.getBon(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view Bon by code")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving Bon by code"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/BonByCode/{code}")
	public ResponseEntity<Bon> getBonByCode(@PathVariable String code){
		Bon res = bonMetier.getBon(code);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view Bon by id client")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving Bon by id client"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/BonByIdClient/{id}")
	public ResponseEntity<Bon> getBonByIdClient(@PathVariable Long id){
		Bon res = bonMetier.getBon(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "save Bon ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "save Bon "),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@Transactional
	@PostMapping("/saveBon")
	public ResponseEntity<Bon> saveBon(@RequestBody Bon bon){
		Bon res = bonMetier.saveBon(bon);
		return ResponseEntity.ok(res);
	}
	
	@ApiOperation(value = "delete Bon ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "delete Bon by id bon"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@Transactional
	@DeleteMapping("/deleteBon/{id}")
	public ResponseEntity<Boolean>  deleteBon(@PathVariable long id){
		boolean res = bonMetier.deleteBon(id);
		return ResponseEntity.ok(res);
	}
	
}
