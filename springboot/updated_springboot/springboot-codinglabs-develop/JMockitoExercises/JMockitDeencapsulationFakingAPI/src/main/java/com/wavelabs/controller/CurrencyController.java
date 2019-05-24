package com.wavelabs.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.entities.Country;
import com.wavelabs.entities.Currency;
import com.wavelabs.repositories.CountryRepository;
import com.wavelabs.repositories.CurrencyRepository;

@RestController
public class CurrencyController {
	@Autowired 
	private CountryRepository countryRepository;
	
	@Autowired 
	private CurrencyRepository curRepository;
	
	@RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to country currency value program..!";
    }
	
	@GetMapping(value="currencies/getall")
	@ResponseBody
    public List<Currency> getAllCurrencies() {
        List<Currency> curList = curRepository.findAll();
        return curList;
    }
	
	@GetMapping(value="currency/get/{curId}")
	@ResponseBody
    public Currency getCurrencyById(@PathVariable("curId") Long curId) {
		Currency cur = curRepository.getOne(curId);
		System.out.println("Retrieved Currency: "+cur);
		return cur;
    }
	
	@GetMapping(value="country/get/{countryId}")
	@ResponseBody
    public Country getCountryById(@PathVariable("countryId") Long countryId) {
		return countryRepository.getOne(countryId);
    }
	
	@GetMapping(value="currency/post")
	@ResponseBody
	public Currency postCurrency(@RequestBody Currency currency) {
		System.out.println("Creating new currency record in database: "+currency);
		Country con = currency.getCountry();
		try {
			con = countryRepository.getOne(con.getCountryId());
		}
		catch(EntityNotFoundException e) {
			countryRepository.save(con);
		}
		return curRepository.save(currency);
	}
	
	@GetMapping(value="country/post")
	@ResponseBody
	public Country postCountry(@RequestBody Country country) {
		System.out.println("Creating new country record in database: "+country);
		return countryRepository.save(country);
	}
	
	@DeleteMapping(value="currency/delete/{curId}")
	@ResponseBody
	public String deleteCurrencyById(@PathVariable("curId") Long curId) {
		String response=null;
		System.out.println("Deleting Currency: "+curRepository.getOne(curId));
		try{
			curRepository.deleteById(curId);
			response = "Currency Deleted Succesfully";
		}
		catch(Exception e){
			response = "Failed to Delete Currency: "+e.getMessage();
		}
		return response;
	}
	
	@DeleteMapping(value="country/delete/{countryId}")
	@ResponseBody
	public String deleteCountryById(@PathVariable("countryId") Long countryId) {
		String response=null;
		System.out.println("Deleting Country: "+countryRepository.getOne(countryId));
		try{
			countryRepository.deleteById(countryId);
			response = "Country Deleted Succesfully";
		}
		catch(Exception e){
			response = "Failed to Delete Country: "+e.getMessage();
		}
		return response;
	}
}
