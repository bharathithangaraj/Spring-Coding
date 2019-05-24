package com.wavelabs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Currency {
	@Id
	@GeneratedValue
	private long curId;
	
	@Column(name="currency_name")
	private String currencyName;
	
	@Column(name="val_per_dollar")
	private double valPerDollar;
	
	@OneToOne
	@JoinColumn(name="country_id", nullable=false, unique=true)
	private Country country;

	public Currency() {
		super();
	}

	public Currency(String currencyName, double valPerDollar, Country country) {
		super();
		this.currencyName = currencyName;
		this.valPerDollar = valPerDollar;
		this.country = country;
	}

	public Currency(long curId, String currencyName, double valPerDollar, Country country) {
		super();
		this.curId = curId;
		this.currencyName = currencyName;
		this.valPerDollar = valPerDollar;
		this.country = country;
	}

	public long getCurId() {
		return curId;
	}

	public void setCurId(long curId) {
		this.curId = curId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getValPerDollar() {
		return valPerDollar;
	}

	public void setValPerDollar(double valPerDollar) {
		this.valPerDollar = valPerDollar;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	/*
	@Override
	public String toString() {
		return "Currency [currencyName=" + currencyName + ", valPerDollar=" + valPerDollar + ", country=" + country + "]";
	}
	*/
}
