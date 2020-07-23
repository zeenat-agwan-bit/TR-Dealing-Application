package com.zee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	@Id
	private String regno;
	private String vtype;
	private String brand;
	private String capacity;
	
	@OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
	private List<Booking> bookings;

	@ManyToOne
	private Transporter transporter;
	
	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	@Override
	public String toString() {
		return "Vehicle [regno=" + regno + ", vtype=" + vtype + ", brand=" + brand + ", capacity=" + capacity
				+ ", bookings=" + bookings + ", transporter=" + transporter + "]";
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Vehicle() {
		super();
	}

	

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Vehicle(String regno, String vtype, String brand, String capacity, List<Booking> bookings) {
		super();
		this.regno = regno;
		this.vtype = vtype;
		this.brand = brand;
		this.capacity = capacity;
		this.bookings = bookings;
	}

}
