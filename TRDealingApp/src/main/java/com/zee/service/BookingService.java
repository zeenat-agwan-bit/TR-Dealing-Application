package com.zee.service;

import java.util.List;

import com.zee.domain.Booking;

public interface BookingService {
	public void addBooking(Booking booking);
	public void changeBooking(Booking booking);
	public List<Booking> findAllBookings(String from ,String to);
	public List<Booking> findAllBookings();
	public List<Booking> findAllBookingByTransporter(String email);
	public List<Booking> findAllBookings(String date);
		
}
