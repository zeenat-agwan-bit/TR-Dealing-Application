package com.zee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
private VehicleDAO dao;

	public void saveNewvehicle(Vehicle vehicle) {
	dao.addNewvehicle(vehicle);	
	}

	public void changeVehicle(Vehicle vehicle) {
	dao.updateVehicle(vehicle);	
	}

	public Vehicle findVehicleById(String regno) {
		
		return dao.getVehicleById(regno);
	}

	public List<Vehicle> findAllVehicle() {
		
		return dao.getAllVehicle();
	}

	public List<String> findAllRegNo(String email) {
		
		return dao.getAllRegNo(email);
	}

	public List<Vehicle> findAllVehicleByTransp(String email) {
		
		return dao.getAllVehicleByTransp(email);
	}

	public void removeVehicle(String regno) {
		dao.deleteVehicle(regno);
	}

	public Map<String, String> findAllRegnosMap(String email) {
		return dao.getAllRegnosMap(email);
	}
	
}
