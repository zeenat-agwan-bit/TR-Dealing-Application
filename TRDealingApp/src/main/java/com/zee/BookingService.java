package com.zee;

import java.util.List;

public interface BookingService {
	public void addBooking(Booking booking);
	public void changeBooking(Booking booking);
	public List<Booking> findAllBookings(String from ,String to);
	public List<Booking> findAllBookings();
	public List<Booking> findAllBookingByTransporter(String email);
	public List<Booking> findAllBookings(String date);
		
}
