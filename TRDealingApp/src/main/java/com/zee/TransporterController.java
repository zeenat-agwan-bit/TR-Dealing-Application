package com.zee;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransporterController {
	@Autowired
	private TransporterService transporterService;

	@RequestMapping("/transporterentry")
	public ModelAndView showTransporterForm() {
		ModelAndView mv = new ModelAndView("transporterentry");
		mv.addObject("transporter", new Transporter());
		List<String> cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Bhopal");
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nagpur");
		cities.add("Banglore");

		mv.addObject("cities", cities);
		List<String> states = new ArrayList<String>();
		states.add("MP");
		states.add("MH");
		states.add("Delhi");
		states.add("Rj");

		mv.addObject("states", states);
		return mv;
	}

	/*
	 * @RequestMapping("savetransporter") public ModelAndView
	 * saveTransporter(@ModelAttribute("transporter") Transporter transporter) {
	 * transporterService.addTransporter(transporter); ModelAndView mv = new
	 * ModelAndView("transportersave"); return mv; }
	 */
	
	@RequestMapping("/savetransporter")
	public String saveTransporter(@Valid @ModelAttribute("transporter") Transporter transporter ,BindingResult result) {
		if (result.hasErrors()) {
		return "transporterentry";
		}
		transporterService.addTransporter(transporter);
		return "transportersave";
	}
	
	@RequestMapping("/updatetransporterprofile")
	public ModelAndView showUpdateForm(@RequestParam("email") String email) {
		ModelAndView mv=new ModelAndView("transporterupdateform");
		Transporter transporter=transporterService.searchTransById(email);
		mv.addObject("transporter", transporter); //request-scope
		List<String> cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Bhopal");
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nagpur");
		cities.add("Banglore");

		mv.addObject("cities", cities);
		List<String> states = new ArrayList<String>();
		states.add("MP");
		states.add("MH");
		states.add("DELHI");
		states.add("RJ");

		mv.addObject("states", states);
		return mv;
	}
	
	@RequestMapping("/updatetransporter")    //action
	public ModelAndView UpdateStudentData(@ModelAttribute ("transporter") Transporter transporter) {
	transporterService.changeTransporter(transporter);
	ModelAndView mv=new  ModelAndView("transporterupdated");
	return mv;
	}
	@RequestMapping("/transporterhome")
	public String customeHome() {
		return "transporterpage";
	}
	
	
}
