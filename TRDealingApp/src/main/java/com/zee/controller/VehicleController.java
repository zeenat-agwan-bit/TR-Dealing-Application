package com.zee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.zee.domain.Transporter;
import com.zee.domain.Vehicle;
import com.zee.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping("savevehiclechanges")
	public ModelAndView saveVehicleChanges(@ModelAttribute("vehicle") Vehicle vehicle,
			@SessionAttribute("email") String email) {
		Transporter transporter = new Transporter();
		transporter.setEmail(email);
		vehicle.setTransporter(transporter);
		vehicleService.changeVehicle(vehicle);
		ModelAndView mv = new ModelAndView("redirect:vehiclelist");
		return mv;
	}

	@RequestMapping("updatevehicle")
	public ModelAndView showVehicleUpdateForm(@RequestParam("regno") String regno) {
		ModelAndView mv = new ModelAndView("vehicleupdateform");
		Vehicle vehicle = vehicleService.findVehicleById(regno);
		mv.addObject("vehicle", vehicle);
		List<String> brands = new ArrayList<String>();
		brands.add("Tata");
		brands.add("Suzuki");
		brands.add("Mazda");
		brands.add("Mahindra");
		mv.addObject("brands", brands);
		List<String> vtypes = new ArrayList<String>();
		vtypes.add("Truck");
		vtypes.add("Tanker");
		vtypes.add("Dumper");
		vtypes.add("Lorry");
		mv.addObject("vtypes", vtypes);
		mv.addObject("brands", brands);
		return mv;
	}

	@RequestMapping("removevehicle")
	public ModelAndView unregistervehicle(@RequestParam("regno") String regno) {
		vehicleService.removeVehicle(regno);
		ModelAndView mv = new ModelAndView("redirect:vehiclelist");
		return mv;

	}

	@RequestMapping("vehiclelist")
	public ModelAndView showVehicleList(@SessionAttribute("email") String email) {
		// System.out.println("EMAIL : "+email);
		List<Vehicle> vehicles = vehicleService.findAllVehicleByTransp(email);
		//System.out.println(vehicles);
		//System.out.println(vehicles.size());
		ModelAndView mv = new ModelAndView("vehiclelist");
		mv.addObject("vehicles", vehicles);
		return mv;
	}

	@RequestMapping("/vehicleentry")
	public ModelAndView vehicleEntryForm() {
		ModelAndView mv = new ModelAndView("vehicleentryform");
		Vehicle vehicle = new Vehicle();
		mv.addObject("vehicle", new Vehicle());
		List<String> brands = new ArrayList<String>();
		brands.add("Tata");
		brands.add("Suzuki");
		brands.add("Mazda");
		brands.add("Mahindra");
		mv.addObject("brands", brands);
		List<String> vtypes = new ArrayList<String>();
		vtypes.add("Truck");
		vtypes.add("Tanker");
		vtypes.add("Dumper");
		vtypes.add("Lorry");
		mv.addObject("vtypes", vtypes);
		return mv;
	}

	@RequestMapping("savevehicle")
	public ModelAndView saveVehicleData(@ModelAttribute("vehicle") Vehicle vehicle,
			@SessionAttribute("email") String email) {
		Transporter transporter = new Transporter();
		transporter.setEmail(email);
		vehicle.setTransporter(transporter);
		vehicleService.saveNewvehicle(vehicle);
		ModelAndView mv = new ModelAndView("vehiclesaved");
		return mv;
	}

	/*
	 * @RequestMapping("savevehicle") public ModelAndView
	 * saveCity(@ModelAttribute("vehicle") Vehicle vehicle){
	 * vehicleService.saveNewvehicle(vehicle); ModelAndView mv=new
	 * ModelAndView("vehiclesaved"); return mv; }
	 * 
	 * 
	 */
}
