package com.zee;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("loadimage")
	public void loadImage(@RequestParam("email") String email ,HttpServletResponse response) {
	Customer customer=customerService.searchCustById(email);
	Blob blob=customer.getDisplay_profile();
	byte b[]=null;
	try {
		b = blob.getBytes(1, (int) blob.length()); // 1-from begining
		
		// we need to send this byte array to client as response.
        ServletOutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

	@RequestMapping("/customerentry")
	public ModelAndView showCustomerForm() {
		ModelAndView mv = new ModelAndView("customerentry");
		mv.addObject("customer", new Customer());
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
		states.add("RJ");

		mv.addObject("states", states);
		return mv;
	}

	@RequestMapping("/savecustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, @RequestParam("f1") MultipartFile file ,BindingResult result) 
	{
		if (result.hasErrors()) {
		return "customerentry";
		}
		byte b[] = null;
		try {
			// converting a MultipartFile object to an array of bytes
			b = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// converting bytes to a Blob objects
		Blob blob = BlobProxy.generateProxy(b);
		customer.setDisplay_profile(blob);
		customerService.addCustomer(customer);
		return "customersave";
	}
	
	@RequestMapping("/updatecustomerprofile")
	public ModelAndView showUpdateForm(@RequestParam("email") String email) {
		ModelAndView mv=new ModelAndView("customerupdateform");
		Customer customer=customerService.searchCustById(email);
		System.out.println(customer);
		mv.addObject("customer", customer); //request-scope
		List<String> cities = new ArrayList<String>();
		cities.add("indore");
		cities.add("bhopal");
		cities.add("delhi");
		cities.add("mumbai");
		cities.add("pune");
		cities.add("nagpur");
		cities.add("banglore");

		mv.addObject("cities", cities);
		List<String> states = new ArrayList<String>();
		states.add("mp");
		states.add("mh");
		states.add("delhi");
		states.add("rj");

		mv.addObject("states", states);
		return mv;
	}
	
	@RequestMapping("/updatecustomer")    //action
	public ModelAndView UpdateStudentData(@ModelAttribute ("customer") Customer customer) {
	customerService.changeCustomer(customer);
	ModelAndView mv=new  ModelAndView("customerupdated");
	return mv;
	}
	
	
	
	@RequestMapping("/customerlist")
	public ModelAndView showAllCustomers() { 
	List<Customer> customers =customerService.showAllCustomers();	
	ModelAndView mv=new ModelAndView("customerlist");
	mv.addObject("clist", customers);
	List<String> cities = new ArrayList<String>();
	cities.add("indore");
	cities.add("bhopal");
	cities.add("delhi");
	cities.add("mumbai");
	cities.add("pune");
	cities.add("nagpur");
	cities.add("banglore");

	mv.addObject("cities", cities);
	List<String> states = new ArrayList<String>();
	states.add("mp");
	states.add("mh");
	states.add("delhi");
	states.add("rj");

	mv.addObject("states", states);
	return mv;
	}
	
	@RequestMapping("/removecustomerprofile")
	public ModelAndView removecustomer(@RequestParam("email") String email) {
		customerService.removeCustomer(email);
		ModelAndView mv=new ModelAndView("customerremoved");
		return mv;
	}
	
	@RequestMapping("/customerhome")
	public String customeHome() {
		return "customerpage";
	}
}
	