package com.zee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zee.domain.Customer;
import com.zee.domain.Transporter;
import com.zee.service.CustomerService;
import com.zee.service.TransporterService;

@Controller
@SessionAttributes(names= {"username" ,"email"}) //shared
public class UserController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransporterService transporterService;

	@RequestMapping("/verifyuser")
	public ModelAndView verifyUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("utype") String utype) {
		
		if (utype.equals("Admin")) {
			if (email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("admin")) {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("adminpage");
				mv.addObject("email", email);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}
		} 
		else if (utype.equals("Customer")) {
			Customer cust = new Customer();
			cust.setEmail(email);
			cust.setPassword(password);
			Customer c = customerService.verifyUserCustomer(cust);
			System.out.println(c);
			if (c != null) {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("customerpage");
				mv.addObject("email", email);
				mv.addObject("username", c.getCname());
				return mv;
			}
			else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}
		} 
		else {
			Transporter trans = new Transporter();
			trans.setEmail(email);
			trans.setPassword(password);
			Transporter t = transporterService.verifyUserTransporter(trans);
			if (t != null) {
				ModelAndView mv = new ModelAndView("transporterpage");
				mv.addObject("email", email);
				mv.addObject("username", t.getTname());
				return mv;
			} 
			else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}

		}
	}

}