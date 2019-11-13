package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.autreObjet.BestSelling;
import com.example.demo.metier.AnalyticMetier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Analytic")
@Api(value = "Analytic management" , description = "Analytic end points")
public class AnalyticController {
	
	@Autowired AnalyticMetier analyticMetier;
	
	@ApiOperation(value = "view list of best selling produit by qte")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving best selling produit by qte"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/bestSllingQte")
	public ResponseEntity<List<BestSelling>> getBestSellingProduitByQte(){
		List<BestSelling> res= analyticMetier.bestSellingQte();
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
	
	
	@ApiOperation(value = "view list of best selling produit by total vendu")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message  = "Successfully  retrieving best selling produit by total"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")		
	})
	@GetMapping("/bestSllingTotal")
	public ResponseEntity<List<BestSelling>> getBestSellingProduitByTotal(){
		List<BestSelling> res= analyticMetier.bestSellingTotal();
		if(res == null) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(res);
		}
	}
}
