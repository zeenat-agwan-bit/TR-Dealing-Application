package com.zee;

import java.util.List;
import java.util.Map;

public interface VehicleService {
	public void saveNewvehicle(Vehicle vehicle);

	public void changeVehicle(Vehicle vehicle);

	public Vehicle findVehicleById(String regno);

	public List<Vehicle> findAllVehicle();

	public List<String>findAllRegNo(String email);

	public List<Vehicle> findAllVehicleByTransp(String email);
	
	public Map<String,String> findAllRegnosMap(String email);
		

	public void removeVehicle(String regno);

}
