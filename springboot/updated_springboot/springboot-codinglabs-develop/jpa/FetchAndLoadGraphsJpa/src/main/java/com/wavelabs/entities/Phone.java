package com.wavelabs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	private long id;
	private String number;
	private String type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", type=" + type + "]";
	}
	
	public Phone(long id, String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}
	
	public Phone() {
		super();}
	
	
	
}
