package com.zee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
private BookingDAO dao;

	public void addBooking(Booking booking) {
		dao.saveBooking(booking);
	}

	public void changeBooking(Booking booking) {
		dao.updateBooking(booking);
	}

	

	public List<Booking> findAllBookings() {
		
		return dao.getAllBookings();
	}

	public List<Booking> findAllBookingByTransporter(String email) {
		return dao.getAllBookingByTransporter(email);
	}

	public List<Booking> findAllBookings(String from, String to) {
		
		return dao.getAllBookings(from, to);
	}

	public List<Booking> findAllBookings(String date) {
		
		return dao.getAllBookings(date);
	}
	
}
