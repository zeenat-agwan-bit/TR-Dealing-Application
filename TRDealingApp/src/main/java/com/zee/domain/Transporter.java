package com.zee.domain;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
public class Transporter {
	@Id
	@Email(message="Invalid Email Address")
	private String email;
	private String password;
	@Size(min = 3, max = 15)
	private String tname;
	private String address;
	private String city;
	private String state;
	@Size(min = 10, max = 12)
	private String mobile;
	private String phone;

	@OneToMany(mappedBy ="transporter",fetch = FetchType.EAGER) // no extra field created2
	private List<Vehicle> vehicles;
	
	

	public Transporter(String email, String password, String tname, String address, String city, String state,
			String mobile, String phone, List<Vehicle> vehicles) {
		super();
		this.email = email;
		this.password = password;
		this.tname = tname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mobile = mobile;
		this.phone = phone;
		this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

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

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public Transporter() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Transporter [email=" + email + ", password=" + password + ", tname=" + tname + ", address=" + address
//				+ ", city=" + city + ", state=" + state + ", mobile=" + mobile + ", phone=" + phone + ", vehicles="
//				+ vehicles + "]";
//	}

	
}
