package com.example.demo.di.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Engine {

	String ename;

	public Engine() {
		// TODO Auto-generated constructor stub
	}

	public Engine(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}
	
	

}
