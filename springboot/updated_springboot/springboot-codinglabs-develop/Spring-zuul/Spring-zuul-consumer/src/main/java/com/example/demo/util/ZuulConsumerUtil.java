package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Accounts;

public class ZuulConsumerUtil {
	
	public static List<Accounts> getAccounts(){
		List<Accounts> aclist=new ArrayList<>();
		
		Accounts ac1=new Accounts();
		ac1.setAcno(120);
		ac1.setName("consumer1");
		ac1.setBranchName("hitech city");
		ac1.setBalance(25000);
		aclist.add(ac1);
		
		Accounts ac2=new Accounts();
		ac2.setAcno(121);
		ac2.setName("consumer5");
		ac2.setBranchName("gachibowli");
		ac2.setBalance(25000);
		aclist.add(ac2);
		
		Accounts ac3=new Accounts();
		ac3.setAcno(122);
		ac3.setName("consumer2");
		ac3.setBranchName("hitech city");
		ac3.setBalance(25000);
		aclist.add(ac3);
		
		Accounts ac4=new Accounts();
		ac4.setAcno(123);
		ac4.setName("consumer3");
		ac4.setBranchName("gachibowli");
		ac4.setBalance(25000);
		aclist.add(ac4);
		
		Accounts ac5=new Accounts();
		ac5.setAcno(124);
		ac5.setName("consumer4");
		ac5.setBranchName("hitech city");
		ac5.setBalance(25000);
		aclist.add(ac5);
		
		return aclist;
	}

}
