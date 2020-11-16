package com.zee.domain;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Customer {
	@Id
	@Email(message = "Invalid Email Address")
	private String email;
	private String password;

	// @Pattern(regexp = "[a-zA-Z]")

	@Size(min = 3, max = 15)
	private String cname;
	private Blob display_profile;

	public Blob getDisplay_profile() {
		return display_profile;
	}

	public void setDisplay_profile(Blob display_profile) {
		this.display_profile = display_profile;
	}

	private String address;
	private String city;
	private String state;
	@Size(min = 10, max = 12)
	private String mobile;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Customer(String email, String password, String cname, Blob display_profile, String address, String city,
			String state, String mobile) {
		super();
		this.email = email;
		this.password = password;
		this.cname = cname;
		this.display_profile = display_profile;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mobile = mobile;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + ", cname=" + cname + ", display_profile="
				+ display_profile + ", address=" + address + ", city=" + city + ", state=" + state + ", mobile="
				+ mobile + "]";
	}

}