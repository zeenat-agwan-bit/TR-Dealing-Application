package com.zee;

import java.util.List;

public interface BookingDAO {
	public void saveBooking(Booking booking);
	public void updateBooking(Booking booking);
	public List<Booking> getAllBookings(String from ,String to);
	public List<Booking> getAllBookings();
	public List<Booking> getAllBookingByTransporter(String email);
	public List<Booking> getAllBookings(String date);

	
}
