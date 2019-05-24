package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Accounts;
import com.example.demo.util.ZuulConsumerUtil;

@Service
public class AccountsService {

	public Accounts getAccountsDetails(int acno) {

		List<Accounts> aclist = ZuulConsumerUtil.getAccounts();

		// java8 for getting single object from list
		Optional<Accounts> acnt = aclist.stream().filter(a -> a.getAcno() == acno).findFirst();

		// regular for each iterator to get single object
		for (Accounts accounts : aclist) {
			if (accounts.getAcno() == acno) {
				return accounts;
			}
		}
		return acnt.get();
	}

	public List<Accounts> getAccountsDetailsByBranch(String branch) {
		List<Accounts> aclist = ZuulConsumerUtil.getAccounts();

		// java8 for getting single object from list
		//List<Accounts> acnt = aclist.stream().filter(a -> a.getBranchName().equals(branch)).collect(Collectors.toList());

		// regular for each iterator to get single object
		List<Accounts>ans=new ArrayList<>();
		for (Accounts accounts : aclist) {
			if (accounts.getBranchName().equals(branch)) {
				ans.add(accounts);
			}
		}
		return ans;
	}

	public List<Accounts> getAccountsDetailsByName(String name) {
		List<Accounts> aclist = ZuulConsumerUtil.getAccounts();

		// regular for each iterator to get single object
		List<Accounts>ans=new ArrayList<>();
		for (Accounts accounts : aclist) {
			if (accounts.getName().equals(name)) {
				ans.add(accounts);
			}
		}
		return ans;
	}

}
