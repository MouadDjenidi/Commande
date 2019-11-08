package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DetailBon;

public interface IDetailBonServ {
	public List<DetailBon> getAllDetailBon();
	public List<DetailBon> getDetailByIdEntete(long id);
	public DetailBon getDetailBonById(long id);
	public DetailBon saveDetailBon(DetailBon detailBon);
	public List<DetailBon> saveDetailBon(List<DetailBon> list);
	public boolean deleteDetailBon(long id);
	public boolean deleteDetailBonById(long id);
}
