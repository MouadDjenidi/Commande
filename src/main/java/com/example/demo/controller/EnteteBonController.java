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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EntetBon;
import com.example.demo.service.IEnteteBonServ;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/EnteteBon")
@Api(value = "Entete Bon management" , description = "entete bon end points")
public class EnteteBonController {

	@Autowired
	private IEnteteBonServ iEnteteBonServ;
	
	@ApiOperation(value = "view list of entet bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<entetebon>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/AllEnteteBon")
	public ResponseEntity<List<EntetBon>> getAllEnteteBon(){
		List<EntetBon> res = iEnteteBonServ.getAllEnteteBon();
		if(res == null) {
			return ResponseEntity.noContent().build();	
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view entete when id is ?")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully retrieving entete by id"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404,message = "The resource you were trying to reach is not found")
			
	})
	@GetMapping("/EnteteBonById/{id}")
	public ResponseEntity<EntetBon> getEnteteBonById(@PathVariable long id){
		EntetBon res = iEnteteBonServ.getEntetBonById(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view entete bon when code is ?")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully retrieving entete bon by code"),
			@ApiResponse(code = 401,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404,message = "The resource you were trying to reach is not found")
			
	})
	@GetMapping("/EnteteBonByCode/{code}")
	public ResponseEntity<EntetBon> getEnteteBonByCode(@PathVariable String code){
		EntetBon res = iEnteteBonServ.getEntetBonByCode(code);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view list of entet bon by id client")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<entetebon> by id client"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/EnteteBonByIdCleint/{id}")
    public ResponseEntity<List<EntetBon>> getEntetBonByIdClient(@PathVariable long id){
		List<EntetBon> res = iEnteteBonServ.getAllEnteteBonByClient(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}{
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "save a entete bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully inserting entete bon"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@PostMapping("/saveEnteteBon")
	public ResponseEntity<EntetBon> saveEnteteBon(@RequestBody EntetBon entetBon){
		EntetBon res = iEnteteBonServ.saveEnteteBon(entetBon);
		return ResponseEntity.ok(res);
	}
	
	@ApiOperation(value = "delete a entete bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully deleting entete bon"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@DeleteMapping("/deleteEnteteBon/{id}")
	public ResponseEntity<Boolean> deleteEnteteBon(@PathVariable long id){
		boolean res = iEnteteBonServ.deleteEnteteBon(id);
		return ResponseEntity.ok(res);
	}
	
}
