package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.DetailsNotFoundException;
import com.example.demo.model.SBICustomer;
import com.example.demo.services.SBICuctomerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/SBI")
public class SBICustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(SBICuctomerService.class);

	@Autowired
	SBICuctomerService sbicuctomerService;

	@GetMapping(value = "/getAllCustomers")
	public List<SBICustomer> getAllCustomers() throws JsonProcessingException {

		List<SBICustomer> list = sbicuctomerService.getCustomerDetails();
		return list;
	}

	@PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SBICustomer> createCustomer(@Valid @RequestBody SBICustomer sbic) {
		System.out.println("hello" + sbic.toString());
		SBICustomer scc = null;
		try {
			scc = sbicuctomerService.createCustomer(sbic);

		} catch (DetailsNotFoundException e) {
			// TODO: handle exception
			LOG.error("Customer data is not available");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(scc);
	}

	@PutMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SBICustomer updateCustomer(@RequestBody SBICustomer sbic) {

		return sbicuctomerService.updateCustomer(sbic);
	}

	@DeleteMapping(value = "/deleteCustomer/{customerid}")
	public String deleteCustomer(@PathVariable(value = "customerid") long customerid) {

		sbicuctomerService.deleteCustomer(customerid);

		return "Deleted successfully";
	}

}
