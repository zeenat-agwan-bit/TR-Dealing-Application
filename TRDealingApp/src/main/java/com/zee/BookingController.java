package com.zee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private BookingService bookingService;

	

	@RequestMapping("citysearch")
	public ModelAndView showSearchCityForm() {
		ModelAndView mv = new ModelAndView("citysearch");
		mv.addObject("booking", new Booking());
		List<String> cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Bhopal");
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nagpur");
		cities.add("Banglore");

		mv.addObject("cities", cities);
		return mv;
	}
	
	@RequestMapping("searchcitybooking")
	public ModelAndView showCitySearchResult(@RequestParam("sourceCity") String from, @RequestParam("destCity") String to){
		List<Booking> bookings=bookingService.findAllBookings(from, to);
		ModelAndView mv=new ModelAndView("bookinglist");
		mv.addObject("bookings",bookings);
		return mv;
		
	}

	@RequestMapping("datesearch")
	public String showDateSearchForm() {
		return "datesearch";
	}
	
	@RequestMapping("searchdatebooking")
	public ModelAndView showDateSearchResult(@RequestParam("date") String date){
		List<Booking> bookings=bookingService.findAllBookings(date);
		ModelAndView mv=new ModelAndView("bookinglist");
		mv.addObject("bookings",bookings);
		return mv;
		
	}

	@RequestMapping("bookingentry")
	public ModelAndView showBookEntryForm(@SessionAttribute("email") String email) {
		ModelAndView mv = new ModelAndView("bookingentryform");
		mv.addObject("booking", new Booking());
		List<String> regnos = vehicleService.findAllRegNo(email);
		// Map<String, String> regnos = vehicleService.findAllRegnosMap(email);
		List<String> cities = new ArrayList<String>();
		cities.add("Indore");
		cities.add("Bhopal");
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Pune");
		cities.add("Nagpur");
		cities.add("Banglore");
		mv.addObject("cities", cities);
		mv.addObject("regnos", regnos);
		return mv;
	}

	@RequestMapping("/savebooking")
	public ModelAndView saveBooking(@ModelAttribute("booking") Booking booking) {
		bookingService.addBooking(booking);
		ModelAndView mv = new ModelAndView("bookingsaved");
		return mv;
	}

	@RequestMapping("/viewallbookings")
	public ModelAndView viewAllBookins() {
		List<Booking> bookings = bookingService.findAllBookings();
		ModelAndView mv = new ModelAndView("bookinglist");
		mv.addObject("bookings", bookings);
		return mv;
	}

}