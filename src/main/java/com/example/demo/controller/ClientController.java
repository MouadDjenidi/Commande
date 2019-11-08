package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.service.IClientServ;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Client")
@Api(value = "Client management" , description = "Client management end points")
public class ClientController {
	
	@Autowired
	private IClientServ iClientServ;
	
	@ApiOperation(value = "view list of Client")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<client>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/getClients")
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> list = iClientServ.getAllClients();
		if(list == null || list.size() == 0) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@ApiOperation(value = "view client when id is ?")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully retrieving client by id"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404,message = "The resource you were trying to reach is not found")
			
	})
	@GetMapping("/getClientById/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable long id){
		Client client = iClientServ.getClientById(id);
		if(client == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(client);
		}
	}
	
	@ApiOperation(value = "view client when code is ?")
	@ApiResponses(value =  {
			@ApiResponse(code = 200,message = "Successfully retrieving client by code"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getClientByCode/{code}")
	public ResponseEntity<Client> getClientByCode(@PathVariable String code){
		Client res = iClientServ.getClientByCode(code);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view client by nom and pernom")
	@ApiResponses(value =  {
			@ApiResponse(code = 200,message = "Successfully retrieving client "),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getClientByNomPrenom/")
	public ResponseEntity<Client> getClientByNomPrenom(@RequestParam String nom,@RequestParam String prenom){
		Client res = iClientServ.getClientByNP(nom, prenom);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "save a client")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully inserting client"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@PostMapping("/saveClient")
	public ResponseEntity<Client> saveClient(@RequestBody Client client){
		Client res = iClientServ.saveClient(client);
		return ResponseEntity.ok(res);
		
	}
	
	@ApiOperation(value = "delete a client")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully deleting client"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<Boolean> deleteClient(@PathVariable long id){
		boolean res = iClientServ.deleteClient(id);
		return ResponseEntity.ok(res);
	}
	
}
