package com.wavelabs.controller;

import org.junit.Test;

import com.wavelabs.entities.Country;
import com.wavelabs.entities.Currency;
import com.wavelabs.repositories.CurrencyRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class CurrencyControllerTest {
	@Tested
	private CurrencyController currencyController;
	
	@Injectable
	CurrencyRepository currencyRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetCurrencyById(){
		new Expectations(){{
			currencyRepository.getOne(1l);
			times = 1;
			result = new Currency(1l,"US Dollar", 1, new Country("USA","New York"));
		}};
		
		currencyController.getCurrencyById(1l);		
	}
}
