package com.zee.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Booking {
	@Id
	@SequenceGenerator(name = "bcode_generator", sequenceName = "bcode_gen", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bcode_generator")
	private int bcode;
	private String sourceCity;
	private String destCity;
	private Date date;
	private int fare;


	@ManyToOne
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Booking [bcode=" + bcode + ", sourceCity=" + sourceCity + ", destCity=" + destCity + ", date=" + date
				+ ", fare=" + fare + "]";
	}

	public Booking(int bcode, String sourceCity, String destCity, Date date, int fare) {
		super();
		this.bcode = bcode;
		this.sourceCity = sourceCity;
		this.destCity = destCity;
		this.date = date;
		this.fare = fare;

	}

	public Booking() {
		super();
	}

}
