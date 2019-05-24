package com.wavelabs.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wavelabs.entities.Country;
import com.wavelabs.entities.Currency;
import com.wavelabs.repositories.CountryRepository;
import com.wavelabs.repositories.CurrencyRepository;

public class CurrencyControllerTest {
	//Mocked types and instances
	@Mock
	CountryRepository countryRepository;
	
	@Mock
	CurrencyRepository currencyRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	private CurrencyController currencyController;
	
	@Test
	public void testGetAllCurrencies(){
		List<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency(1,"US Dollar", 1, new Country("USA","New York")));
		currencyList.add(new Currency(2,"Canadian Dollar", 1.31, new Country("Canada","Ottawa")));
		currencyList.add(new Currency(3,"Australian Dollar", 1.38, new Country("Australia","Canberra")));
		when(currencyController.getAllCurrencies()).thenReturn(currencyList);
		
		List<Currency> result = currencyController.getAllCurrencies();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetCurrencyById(){
		Currency usd = new Currency(1,"US Dollar", 1.0, new Country("USA","New York"));

		when(currencyRepository.getOne(1L)).thenReturn(usd);
		
		Currency result = currencyController.getCurrencyById(usd.getCurId());
		
		assertEquals(1, result.getCurId());
		assertEquals("US Dollar", result.getCurrencyName());
		assertEquals("1.0", result.getValPerDollar()+"");
		assertEquals("USA", result.getCountry().getCountryName());
		assertEquals("New York", result.getCountry().getCapital());
	}
	
	@Test
	public void testPostCurrency(){
		Currency ausDollar = new Currency(3,"Australian Dollar", 1.38, new Country("Australia","Canberra"));
		
		when(currencyRepository.save(ausDollar)).thenReturn(ausDollar);
		
		Currency result = currencyController.postCurrency(ausDollar);
		
		assertEquals(3, result.getCurId());
		assertEquals("Australian Dollar", result.getCurrencyName());
		assertEquals("1.38", result.getValPerDollar()+"");
		assertEquals("Australia", result.getCountry().getCountryName());
		assertEquals("Canberra", result.getCountry().getCapital());
	}

}
