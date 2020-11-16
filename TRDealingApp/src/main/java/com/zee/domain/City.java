package com.zee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int citycode;
	private String cityname;
	private String state;

	public int getCitycode() {
		return citycode;
	}

	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [citycode=" + citycode + ", cityname=" + cityname + ", state=" + state + "]";
	}

	public City(int citycode, String cityname, String state) {
		super();
		this.citycode = citycode;
		this.cityname = cityname;
		this.state = state;
	}

	public City() {
		super();
	}

}
