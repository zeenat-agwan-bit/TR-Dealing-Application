package com.zee.dao;

import java.util.List;

import com.zee.domain.City;


public interface CityDAO {
	public void saveCity(City city);
	public void updateCity(City city);
	public List<String> getAllCities();
	public List<String> getAllStateNames();

}
