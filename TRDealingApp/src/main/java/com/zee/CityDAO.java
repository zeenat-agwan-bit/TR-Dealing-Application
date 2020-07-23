package com.zee;

import java.util.List;


public interface CityDAO {
	public void saveCity(City city);
	public void updateCity(City city);
	public List<String> getAllCities();
	public List<String> getAllStateNames();

}
