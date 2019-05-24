package com.example.demo.di.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	private Engine engine;
	private Transmission transmission;

	@Autowired
	public Car(Engine engine, Transmission transmission) {
		this.setEngine(engine);
		this.setTransmission(transmission);
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}