package com.wavelabs;

public class SubClass extends SuperClass{
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public SubClass(String data) {
		super(data);
		this.data = data;
		System.out.println("Added Data: "+data);
	}
	
}
