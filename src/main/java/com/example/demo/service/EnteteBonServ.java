package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EntetBon;
import com.example.demo.Repository.EnteteBonRepository;

@Service
public class EnteteBonServ implements IEnteteBonServ{
	
	@Autowired
	private EnteteBonRepository enteteBonRepository;

	
	@Override
	public EntetBon saveEnteteBon(EntetBon entetBon) {
		EntetBon eb = enteteBonRepository.save(entetBon);
		return eb;
	}


	@Override
	public EntetBon getEntetBonById(long id) {
		return  enteteBonRepository.findById(id).orElse(null);
	}


	@Override
	public EntetBon getEntetBonByCode(String code) {
		return enteteBonRepository.getEnteteByCode(code);
	}


	@Override
	public boolean deleteEnteteBon(long id) {
		boolean test = false; 
		try {
			enteteBonRepository.deleteById(id);
			test = true;
		} catch (Exception e) {
			e.getStackTrace();
			test = false;
		}
		return test;
	}


	@Override
	public List<EntetBon> getAllEnteteBon() {
		return enteteBonRepository.findAll();
	}


	@Override
	public List<EntetBon> getAllEnteteBonByClient(long idClient) {
		return enteteBonRepository.getByIdClient(idClient);
	}

}