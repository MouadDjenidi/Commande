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

import com.example.demo.model.DetailBon;
import com.example.demo.service.IDetailBonServ;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/DetailBon")
@Api(value = "Detail bon management" , description = "detail bon end points")
public class DetailBonController {
	
	@Autowired
	private IDetailBonServ iDetailBonServ;
	
	@ApiOperation(value = "view list of detail bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<detail>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/allDetailBon")
	public ResponseEntity<List<DetailBon>> getAllDetailBon(){
		List<DetailBon> res = iDetailBonServ.getAllDetailBon();
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view list of detail bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving list<detail>"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/DetailByIdEntete/{id}")
	public ResponseEntity<List<DetailBon>> getDetailByIdEntete(@PathVariable long id){
		List<DetailBon> res = iDetailBonServ.getDetailByIdEntete(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "view  detail bon by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving detail bon by id"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/DetailById/{id}")
	public ResponseEntity<DetailBon> getDetailBonById(@PathVariable long id){
		DetailBon res = iDetailBonServ.getDetailBonById(id);
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	@ApiOperation(value = "save list detail bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully inserting list detail bon"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@PostMapping("/saveDetailBon")
	public ResponseEntity<List<DetailBon>> saveDetailBon(@RequestBody List<DetailBon> list){
		List<DetailBon>  res = iDetailBonServ.saveDetailBon(list);
			return ResponseEntity.ok(res);
	}
	
	@ApiOperation(value = "save one detail bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully inserting one detail bon"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@PostMapping("/saveOneDetailBon")
	public ResponseEntity<DetailBon> saveDetailBon(@RequestBody DetailBon detailBon){
		DetailBon  res = iDetailBonServ.saveDetailBon(detailBon);
			return ResponseEntity.ok(res);
	}
	
	@ApiOperation(value = "delete a deatil bon")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully deleting deatil bon"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@DeleteMapping("/deleteDetailBonByIdEntet/{id}")
	public ResponseEntity<Boolean> deleteDetailBonByIdEntete(@PathVariable long id){
		boolean res = iDetailBonServ.deleteDetailBon(id);
		return ResponseEntity.ok(res);
	}
	
	@ApiOperation(value = "delete a deatil bon by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Successfully deleting deatil bon by id"),
			@ApiResponse(code = 201,message = "You are not authorized to view the resource"),
			@ApiResponse(code = 203,message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204,message = "The resource you were trying to reach is not found")
	})
	@DeleteMapping("/deleteDetailBonById/{id}")
	public ResponseEntity<Boolean> deleteDetailBonById(@PathVariable long id){
		boolean res = iDetailBonServ.deleteDetailBonById(id);
		return ResponseEntity.ok(res);
	}
}
