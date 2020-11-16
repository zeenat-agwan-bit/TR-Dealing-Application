package com.zee.service;

import java.util.List;

import com.zee.domain.City;

public interface CityService {
	public void addCity(City city);
	public void changeCity(City city);
	public List<String> findAllCities();
	public List<String> findAllStateNames();
}
