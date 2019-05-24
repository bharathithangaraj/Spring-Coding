package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Banking;
import com.example.demo.util.ZuulConsumerUtil;

@Service
public class BankingService {

	public Banking getAccountsDetails(int acno) {

		List<Banking> aclist = ZuulConsumerUtil.getAccounts();

		// java8 for getting single object from list
		Optional<Banking> acnt = aclist.stream().filter(a -> a.getCode() == acno).findFirst();

		// regular for each iterator to get single object
		for (Banking accounts : aclist) {
			if (accounts.getCode() == acno) {
				return accounts;
			}
		}
		return acnt.get();
	}

	public List<Banking> getAccountsDetailsByBranch(String branch) {
		List<Banking> aclist = ZuulConsumerUtil.getAccounts();

		// java8 for getting single object from list
		//List<Accounts> acnt = aclist.stream().filter(a -> a.getBranchName().equals(branch)).collect(Collectors.toList());

		// regular for each iterator to get single object
		List<Banking>ans=new ArrayList<>();
		for (Banking accounts : aclist) {
			if (accounts.getBranchName().equals(branch)) {
				ans.add(accounts);
			}
		}
		return ans;
	}

}
