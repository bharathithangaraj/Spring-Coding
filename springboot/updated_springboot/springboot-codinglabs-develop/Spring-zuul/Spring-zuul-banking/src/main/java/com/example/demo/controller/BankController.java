package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Banking;
import com.example.demo.service.BankingService;

@RestController
@RequestMapping(path="/banking")
public class BankController {
	
	@Autowired
	BankingService bankService;
	
	@RequestMapping(path="/getBankDetails/byno/{code}")
	public ResponseEntity<Banking> getAccountDetails(@PathVariable(name = "code") int code){
		Banking accounts=bankService.getAccountsDetails(code);
		return ResponseEntity.status(200).body(accounts);
	}
	@RequestMapping(path="/getBankDetails/bybranch/{branch}")
	public ResponseEntity<List<Banking>> getAccountDetailsByBranch(@PathVariable(name = "branch") String branch){
		List<Banking> accounts=bankService.getAccountsDetailsByBranch(branch);
		return ResponseEntity.status(200).body(accounts);
	}

}
