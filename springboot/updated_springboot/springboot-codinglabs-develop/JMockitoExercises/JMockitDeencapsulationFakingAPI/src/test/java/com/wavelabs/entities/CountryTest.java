package com.wavelabs.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mockit.Deencapsulation;

public class CountryTest {
	private Country country;
	
	@Before
	public void setUp(){
		country = new Country();
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldInvokePrivateMethod(){
		Deencapsulation.invoke(country, "privateCountryName", null);
	}
	
	@Test
	public void shouldInvokePrivateMethodWithParameter(){
		String countryName =  "India";
		Deencapsulation.invoke(country, "privateCountryName", countryName);
		assertEquals("India", countryName.toString());
	}

}
