package com.uaex.config_server;

/**
 * 
 * @author gopi
 *
 */
public class LimitConfiguration {

	private int minimum;
	
	private int maximum;

	private String username;
	
	private String password;
	
	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public LimitConfiguration(int minimum, int maximum, String username, String password) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
		this.username = username;
		this.password = password;
	}


	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
