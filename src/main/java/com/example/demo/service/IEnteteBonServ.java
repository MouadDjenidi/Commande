package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EntetBon;

public interface IEnteteBonServ {
	public List<EntetBon> getAllEnteteBon();
	public EntetBon getEntetBonById(long id);
	public EntetBon getEntetBonByCode(String code);
	public EntetBon saveEnteteBon(EntetBon entetBon);
	public boolean deleteEnteteBon(long id);
	public List<EntetBon> getAllEnteteBonByClient(long idClient);
}
