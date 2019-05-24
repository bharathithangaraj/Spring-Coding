package com.example.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.SBICustomer;
import com.example.demo.repositrory.SBICustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class SBICuctomerService {

	private static final Logger LOG = LoggerFactory.getLogger(SBICuctomerService.class);
	@Autowired
	SBICustomerRepository sbicustomerrepository;

	public List<SBICustomer> getCustomerDetails() throws JsonProcessingException {

		List<SBICustomer> listOfSbiCustomers = sbicustomerrepository.findAll();
		LOG.info("Customer Details ::" + listOfSbiCustomers);
		return listOfSbiCustomers;
	}

	public SBICustomer createCustomer(SBICustomer sbic) {
		LOG.info("create Customer ::" + sbic);
		return sbicustomerrepository.save(sbic);
	}

	public SBICustomer updateCustomer(SBICustomer sbic) {
		LOG.info("update Customer ::" + sbic);
		return sbicustomerrepository.save(sbic);
	}

	public void deleteCustomer(long customerid) {
		SBICustomer sbiCustomer = sbicustomerrepository.getOne(customerid);
		LOG.info("delete Customer ::" + customerid);
		sbicustomerrepository.delete(sbiCustomer);
	}
}
