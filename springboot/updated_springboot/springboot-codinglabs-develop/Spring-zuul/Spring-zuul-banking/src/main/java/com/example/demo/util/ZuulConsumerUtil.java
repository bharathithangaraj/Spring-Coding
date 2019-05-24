package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Banking;

public class ZuulConsumerUtil {
	
	public static List<Banking> getAccounts(){
		List<Banking> aclist=new ArrayList<>();
		
		Banking ac1=new Banking();
		ac1.setCode(120);
		ac1.setBranchName("hitech city");
		ac1.setBalance(25000);
		aclist.add(ac1);
		
		Banking ac2=new Banking();
		ac2.setCode(121);
		ac2.setBranchName("gachibowli");
		ac2.setBalance(25000);
		aclist.add(ac2);
		
		Banking ac3=new Banking();
		ac3.setCode(122);
		ac3.setBranchName("hitech city");
		ac3.setBalance(25000);
		aclist.add(ac3);
		
		Banking ac4=new Banking();
		ac4.setCode(123);
		ac4.setBranchName("gachibowli");
		ac4.setBalance(25000);
		aclist.add(ac4);
		
		Banking ac5=new Banking();
		ac5.setCode(124);
		ac5.setBranchName("hitech city");
		ac5.setBalance(25000);
		aclist.add(ac5);
		
		return aclist;
	}

}
