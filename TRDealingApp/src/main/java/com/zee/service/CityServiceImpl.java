package com.zee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.dao.CityDAO;
import com.zee.domain.City;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDAO dao;

	public void addCity(City city) {
		dao.saveCity(city);
	}

	public void changeCity(City city) {
		dao.updateCity(city);
	}

	public List<String> findAllCities() {
		return dao.getAllCities();
	}

	public List<String> findAllStateNames() {

		return dao.getAllStateNames();
	}

}
