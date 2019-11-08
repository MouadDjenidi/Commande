package com.example.demo.service;

import java.util.List;

import com.example.demo.autreObjet.BestSelling;

public interface IAnalyticServ {	
	public List<BestSelling> bestSellingQte();
	public List<BestSelling> bestSellingTotal();
}
