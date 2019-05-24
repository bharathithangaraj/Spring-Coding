package com.wavelabs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Country {
	@Id
	@GeneratedValue
	@Column(name="country_id")
	private long countryId;
	
	@Column(name="country_name")
	private String countryName;

	private String capital;
	
	public Country(long countryId, String countryName, String capital) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.capital = capital;
	}
	
	public Country(String countryName, String capital) {
		super();
		this.countryName = countryName;
		this.capital = capital;
	}

	public Country() {
		super();
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	/*
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", capital=" + capital + "]";
	}
	*/
}
