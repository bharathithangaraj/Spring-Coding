package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Accounts;
import com.example.demo.service.AccountsService;

@RestController
@RequestMapping(path="/accounts")
public class AccountsController {
	
	@Autowired
	AccountsService accountsService;
	
	@RequestMapping(path="/getAccountDetails/byno/{acno}")
	public ResponseEntity<Accounts> getAccountDetails(@PathVariable(name = "acno") int acno){
		Accounts accounts=accountsService.getAccountsDetails(acno);
		return ResponseEntity.status(200).body(accounts);
	}
	@RequestMapping(path="/getAccountDetails/bybranch/{branch}")
	public ResponseEntity<List<Accounts>> getAccountDetailsByBranch(@PathVariable(name = "branch") String branch){
		List<Accounts> accounts=accountsService.getAccountsDetailsByBranch(branch);
		return ResponseEntity.status(200).body(accounts);
	}
	@RequestMapping(path="/getAccountDetails/byname{name}")
	public ResponseEntity<List<Accounts>> getAccountDetailsByName(@PathVariable(name = "name") String name){
		List<Accounts> accounts=accountsService.getAccountsDetailsByName(name);
		return ResponseEntity.status(200).body(accounts);
	}
	

}
