package com.example.demo.metier;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.autreObjet.BestSelling;
import com.example.demo.service.IAnalyticServ;

@Service
public class AnalyticMetier {
	  @Autowired
	  private IAnalyticServ iAnalyticServ;
	  
	  public  List<BestSelling> bestSellingQte(){
		  List<BestSelling> list = iAnalyticServ.bestSellingQte();
		  List<BestSelling> res =  null; 
		  if(list != null) {
			  BestSelling b = list
					  .stream()
			          .max(Comparator.comparing(BestSelling::getVar))
			          .orElseThrow(NoSuchElementException::new);

			  res = list.stream()              
		                .filter(item -> b.getVar() == item.getVar()) 
		                .collect(Collectors.toList());
		  } 
		  return res;
	  }
	  
	  
	  public  List<BestSelling> bestSellingTotal(){
		  List<BestSelling> list = iAnalyticServ.bestSellingTotal();
		  List<BestSelling> res =  null; 
		  if(list != null) {
			  BestSelling b = list
					  .stream()
			          .max(Comparator.comparing(BestSelling::getVar))
			          .orElseThrow(NoSuchElementException::new);

			  res = list.stream()              
		                .filter(item -> b.getVar() == item.getVar()) 
		                .collect(Collectors.toList());
		  } 
		  return res;
	  }
}