package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DetailBon;
import com.example.demo.Repository.DetailBonRepository;

@Service
public class DetailBonServ implements IDetailBonServ{

	@Autowired
	private DetailBonRepository detailBonRepository;
	
	//@Autowired
    //private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DetailBon> saveDetailBon(List<DetailBon> list) {
		List<DetailBon> listres = detailBonRepository.saveAll(list);
		return listres;
	}

	@Override
	public List<DetailBon> getDetailByIdEntete(long id) {
		return detailBonRepository.getById(id);
	}

	@Override
	public boolean deleteDetailBon(long id) {
		boolean test = false;
		try {
			//String SQL = "delete from detail_bon where entet_bon_id = ?";
			//jdbcTemplate.update(SQL, id);
			detailBonRepository.deleteDeatilBon(id);
			test = true;
		}catch (Exception e) {
			test = false;
			e.getStackTrace();
		}
		return test;
	}

	@Override
	public List<DetailBon> getAllDetailBon() {
		return detailBonRepository.findAll();
	}

	
	@Override
	public DetailBon saveDetailBon(DetailBon detailBon) {	
		return detailBonRepository.save(detailBon);
	}

	@Override
	public DetailBon getDetailBonById(long id) {
		return detailBonRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteDetailBonById(long id) {
		boolean test = false;
		try {
			detailBonRepository.deleteById(id);
			test = true;
		}catch (Exception e) {
			test = false;
		}
		return test;
	}

}