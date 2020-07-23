package com.zee;

import java.util.List;

public interface CityService {
	public void addCity(City city);
	public void changeCity(City city);
	public List<String> findAllCities();
	public List<String> findAllStateNames();
}
