package com.zee;

import java.util.List;
import java.util.Map;

public interface VehicleDAO {
	public void addNewvehicle(Vehicle vehicle); //save
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(String regno);
	public List<Vehicle> getAllVehicle();
	public List<String> getAllRegNo(String email);
	public List<Vehicle> getAllVehicleByTransp(String email);
	public Map<String,String> getAllRegnosMap(String email);
	public void deleteVehicle(String regno);
}
